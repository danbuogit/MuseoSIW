package com.dbaab.museo.helpers;

import java.net.URI;

public final class RequestHelper
{
    public static String getControllerFromUrl(String url)
    {
        String template = null;
        try
        {
            URI uri = new URI(url);
            template = uri.getPath();
        }
        catch (Exception e)
        {}

        if (template == null || template.isEmpty() || template.equals("/"))
            template = "/home";

        return template;
    }
}
