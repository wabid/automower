package com.blablacar.mower;

import com.blablacar.mower.application.MowerProgramExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class MowerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MowerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        String mowerProgram =
            new String(
                Files.readAllBytes(Paths.get(
                    new ClassPathResource("mower-program.txt").getFile().getAbsolutePath()))
            );

        System.out.println(
            new MowerProgramExecutor(mowerProgram).execute()
        );

    }
}
