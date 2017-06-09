package com.dbaab.museo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dbaab.museo.model.Role;
import com.dbaab.museo.model.User;
import com.dbaab.museo.service.UserRoleService;
import com.dbaab.museo.service.UserService;

/** This {@link CommandLineRunner} bean is run by the {@link SpringApplication}
 * and is used to add new administrators to the database.
 * @author Alessandro */
@Component
public class AddAdministratorsCommandLineRunner implements CommandLineRunner
{
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRoleService userRoleService;
    
    @Override
    public void run(String... args) throws Exception
    {
        if (args != null)
        {
            for (String arg : args)
            {
                if (arg.startsWith("--add-admins"))
                {
                    // "--add-admin=<username1>,<password1>;<username2>,<password2>;..."
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    
                    String sequence = arg.substring(arg.indexOf('=') + 1);
                    String[] pairs = sequence.split(";");
                    for (String pair : pairs)
                    {
                        if (pair.isEmpty())
                            continue;
                        
                        String[] values = pair.split(",");
                        
                        if (values.length != 2)
                            throw new Exception(String.format("\"%s\" does not contain a \"username,password\" pair.", pair));
                        
                        String username = values[0];
                        String password = values[1];
                        password = passwordEncoder.encode(password);
                        
                        User admin = new User(username, password);
                        admin.addRole(userRoleService.findByRoleOrCreate(Role.ADMIN));
                        
                        userService.save(admin);
                    }
                    
                    // Quit SpringApplication
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
