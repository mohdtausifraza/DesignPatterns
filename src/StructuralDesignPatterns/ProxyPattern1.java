package StructuralDesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Internet{
    public void connectTo(String serverHost) throws Exception;
}

// Real Object
class RealInternet implements Internet{
    @Override
    public void connectTo(String serverHost) throws Exception{
        System.out.println("Connecting to "+serverHost);
    }
}

// Proxy Object
class RealInternetProxy implements Internet{
    private Internet internet;
    private static List<String> bannedSites;

    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }
    @Override
    public void connectTo(String serverHost) throws Exception{
        if (bannedSites.contains(serverHost)){
            throw new Exception("Access denied");
        }
        if (internet==null){
            internet=new RealInternet();
        }
        internet.connectTo(serverHost);
    }
}
public class ProxyPattern1 {
    public static void main(String[] args) {
        Internet internet = new RealInternetProxy();
        try{
            internet.connectTo("learning.com");
            internet.connectTo("abc.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
