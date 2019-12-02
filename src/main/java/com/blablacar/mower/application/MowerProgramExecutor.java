package com.blablacar.mower.application;

import com.blablacar.mower.domain.mower.Mower;
import com.blablacar.mower.domain.mower.Lawn;


/**
 * Created by wassim on 02/12/2019.
 */
public class MowerProgramExecutor {

    private String program;
    private MowerProgramParserBuilder mowerProgramParserBuilder = new MowerProgramParserBuilder();

    public MowerProgramExecutor(String program) {
        this.program = program;
    }

    public String execute() {
        String output = "";
        final LineNumberScanner scanner = new LineNumberScanner(program);
        final Lawn lawn = mowerProgramParserBuilder.buildLawn(scanner.nextLine(), scanner.getLineNumber());
        while (scanner.hasNextLine()) {
            final Mower mower = executeOneMowerProgram(scanner, lawn);
            output += mower.toString()+"\r\n";
        }
        return output;
    }

    private Mower executeOneMowerProgram(LineNumberScanner scanner, Lawn lawn) {

        final Mower mower = mowerProgramParserBuilder.buildMower(scanner.nextLine(), lawn, scanner.getLineNumber());
        final String instructions = mowerProgramParserBuilder.buildInstructions(scanner.nextLine(), scanner.getLineNumber());
        mower.executeInstructions(instructions);
        return mower;
    }


}
