package SomeJava.TemplatePattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding lemon");
    }

    @Override
    boolean customerWantsCondiments() {
        String response = getUserInput();
        return response.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        System.out.println("Would you like lemon with your tea? (y/n)");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String response = "no";
        try {
            response = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }
}
