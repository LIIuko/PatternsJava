package ru.trader.fileconverter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileConverter3Application implements CommandLineRunner {

    @Autowired
    private FileWorker fileWorker;

    public static void main(String[] args) {
        SpringApplication.run(FileConverter3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 2) fileWorker.start(args[0], args[1]);
        else fileWorker.hash();
        // else standard input.txt-output.txt we will see
    }
}
