package by.intexsoft.importexport.shell;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class ShellCommand implements CommandMarker {
    @CliAvailabilityIndicator(value={"echo"})
    public boolean isPrintCommandAvailable(){
        return Boolean.TRUE;
    }

    @CliCommand(value="echo", help = "print text")
    public String commandOne(@CliOption(key={"command"}, mandatory = true, help = "enter command")final String command){
        return "Your message is [" + command + "]";
    }
}
