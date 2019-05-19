package net.mlike.chenhui.one.util;

public class CurrentUser
{
    private static final ThreadLocal<String> token = new ThreadLocal();

    public static void set(String toke)
    {
        token.set(toke);
    }

    public static String get()
    {
        return (String)token.get();
    }
}
