package net.minecraft.src;

public class RConConsoleSource implements ICommandListener
{
    /** Single instance of RConConsoleSource */
    public static final RConConsoleSource instance = new RConConsoleSource();

    /** RCon string buffer for log */
    private StringBuffer buffer;

    public RConConsoleSource()
    {
        buffer = new StringBuffer();
    }

    /**
     * Clears the RCon log
     */
    public void resetLog()
    {
        buffer.setLength(0);
    }

    /**
     * Gets the contents of the RCon log
     */
    public String getLogContents()
    {
        return buffer.toString();
    }

    /**
     * Logs the message with a level of INFO.
     */
    public void log(String par1Str)
    {
        buffer.append(par1Str);
    }

    /**
     * Gets the players username.
     */
    public String getUsername()
    {
        return "Rcon";
    }
}
