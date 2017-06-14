package com.dbaab.museo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    public static void main(String[] args)
    {
        boolean quit = false;
        if (!containsArg("--skip-main", args))
        {
            List<String> argsList = new ArrayList<String>();
            for (String arg : args)
                argsList.add(arg);
            
            quit = selectOperation(argsList);
            if (!quit)
                argsList.add("--skip-main");
            args = argsList.toArray(args);
        }
        
        if (!quit)
            SpringApplication.run(App.class, args);
    }
    
    private static boolean selectOperation(List<String> argsList)
    {
        Scanner scan = new Scanner(System.in);
        String selection = null;
        boolean rePrint = true;
        boolean quit = false;
        while (rePrint)
        {
            System.out.println("1] Just start Spring application!");
            System.out.println("2] Add administrators to the database.");
            System.out.println("3] Quit.");
            
            System.out.print("Whatcha wanna do? ");
            selection = scan.nextLine();
            
            if (selection.equals("1") || selection.isEmpty())
                rePrint = false;
            else if (selection.equals("2"))
            {
                rePrint = false;
                addAdmins(argsList);
            }
            else if (selection.equals("3"))
            {
                rePrint = false;
                quit = true;
            }
            else
                rePrint = true;
            
            clearConsole();
        }
        
        scan.close();
        return quit;
    }
    
    /** Adds administrators to the list of arguments to pass to the SpringApplication and to its CommandLineRunner beans.
     * @param argsList - the list of arguments */
    private static void addAdmins(List<String> argsList)
    {
        // The argument is gonna be in this format: "--add-admins=<username1>,<password1>;<username2>,<password2>;..."
        String arg = "--add-admins=";
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("  Adding administrators  ");
        System.out.println("-------------------------");
        System.out.println();
        try
        {
            System.out.print("Number of administrators to add: ");
            int N = scan.nextInt();
            if (scan.hasNextLine()) // discard \n
                scan.nextLine();
            
            List<String> admins = new ArrayList<String>(N);
            for (int i = 1; i <= N; ++i)
            {
                String name, password;
                System.out.println();
                System.out.println(String.format("[%s]", i));
                
                System.out.print("Name: ");
                name = scan.nextLine();
                
                System.out.print("Password: ");
                password = scan.nextLine();
                
                admins.add(name + "," + password);
            }
            arg += String.join(";", admins);
            argsList.add(arg);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            scan.close();
        }
        System.out.println();
    }
    
    private static void clearConsole()
    {
        for (int i = 0; i < 32; ++i)
            System.out.println();
    }
    
    private static boolean containsArg(String arg, String[] args)
    {
        for (String a : args)
        {
            if (a.equals(arg))
                return true;
        }
        return false;
    }
}
