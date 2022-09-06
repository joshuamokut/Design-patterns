package SomeJava;


import SomeJava.AdapterPattern.Adapters.IteratorEnumeration;
import SomeJava.AdapterPattern.Adapters.TurkeyDuckAdapter;
import SomeJava.AdapterPattern.Implementations.MallardDuck;
import SomeJava.AdapterPattern.Implementations.WildTurkey;
import SomeJava.AdapterPattern.Interaces.Duck;
import SomeJava.CommandPattern.CommandImplementations.*;
import SomeJava.CommandPattern.CommandInterfaces.Command;
import SomeJava.CommandPattern.Devices.*;
import SomeJava.CommandPattern.RemoteImplementations.RemoteControl;
import SomeJava.CommandPattern.RemoteImplementations.SimpleRemoteControl;
import SomeJava.SingletonPattern.SingletonExample;
import SomeJava.Starbuzz.*;
import SomeJava.TemplatePattern.CaffeineBeverage;
import SomeJava.TemplatePattern.CaffeineBeverageWithHook;
import SomeJava.TemplatePattern.Tea;
import SomeJava.TemplatePattern.TeaWithHook;
import example.DisplayElement;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        Application application = new Application();
//        application.caffeineTestWithHook();

        SomeJava.TemplatePattern.Duck.testDuckCompare();
    }

    public void caffeineTestWithHook() {
        CaffeineBeverageWithHook tea = new TeaWithHook();
        tea.prepare();
    }

    public void caffeineTest() {
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }

    public void iteratorEnumerationTest() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        Enumeration<Object> it = new IteratorEnumeration(numbers.iterator());
        while (it.hasMoreElements()) {
            System.out.println(it.nextElement());
        }
    }

    public void duckTestDrive() {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapted = new TurkeyDuckAdapter(turkey);

        System.out.println("The turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapted);
    }

    private void testDuck(Duck duck) {
        duck.fly();
        duck.quack();
    }


    public void simpleRemoteTest() {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl(new LightOnCommand(new Light("")));
        remoteControl.buttonWasPressed();
    }

    public void macroCommandTest() {
        Light light = new Light("Living room");
        Stereo stereo = new Stereo("Living room");
        TV tv = new TV("Living room");
        HotTub hotTub = new HotTub();

        Command lightOn = new LightOnCommand(light);
        Command stereoOn = new StereoOnWithCDCommand(stereo);
        Command tvOn = new TVOnCommand(tv);
        Command hotTubOn = new HottubOnCommand(hotTub);

        Command lightOff = new LightOffCommand(light);
        Command stereoOff = new StereoOffCommand(stereo);
        Command tvOff = new TVOffCommand(tv);
        Command hotTubOff = new HotTubOffCommand(hotTub);

        Command[] partyOn = {lightOn, stereoOn, tvOn, hotTubOn};
        Command[] partyOff = {lightOff, stereoOff, tvOff, hotTubOff};

        Command partyOnCommand = new MacroCommand(partyOn);
        Command partyOffCommand = new MacroCommand(partyOff);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, partyOnCommand, partyOffCommand);

        System.out.println(remoteControl);
        System.out.println("----- pushing macro on -------");
        remoteControl.onButtonWasPressed(0);
        System.out.println("----- pushing macro off ------");
        remoteControl.offButtonWasPressed(0);
    }

    public void ceilingFanTest() {
        RemoteControl remoteControl = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("Bedroom");

        Command ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        Command ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        Command ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();

        remoteControl.onButtonWasPressed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();
    }

    public void remoteLoaderWithUndo() {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living room");

        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        System.out.println(remoteControl);

        remoteControl.undoButtonWasPressed();
        remoteControl.offButtonWasPressed(0);
        remoteControl.onButtonWasPressed(0);
        System.out.println(remoteControl);

        remoteControl.undoButtonWasPressed();
    }

    public void remoteLoader() {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living room");
        CeilingFan ceilingFan = new CeilingFan("Living room");

        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        Command garageDoorUp = new GarageDoorOpenCommand(garageDoor);
        Command garageDoorDown = new GarageDoorCloseCommand(garageDoor);

        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        Command stereoOff = new StereoOffCommand(stereo);

        Command ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        Command ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

        System.out.println(remoteControl);

        for (int i = 0; i < 5; i++) {
            remoteControl.onButtonWasPressed(i);
            remoteControl.offButtonWasPressed(i);
        }
    }

    public void simpleRemoteTestWithDoors() {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light("");
        GarageDoor garageDoor = new GarageDoor("");
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarageDoorOpenCommand doorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        remoteControl.setSlot(lightOnCommand);
        remoteControl.buttonWasPressed();

        remoteControl.setSlot(doorOpenCommand);
        remoteControl.buttonWasPressed();
    }

    public void testSingletonExample() {
        SingletonExample example = SingletonExample.getInstance();
        SingletonExample example1 = SingletonExample.getInstance();

        System.out.println(example1 == example);
    }

    public void testStarbuzz() {
        Beverage beverage1 = new Espresso();
        printBeverage(beverage1);

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        printBeverage(beverage2);

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        printBeverage(beverage3);
    }

    public void printBeverage(Beverage beverage) {
        System.out.printf("This is a %s and it goes for %.2f%n%n", beverage.getDescription(), beverage.cost());
    }

    public void testWeatherData() {
        WeatherData weatherData = new WeatherData();
        DisplayElement currentConditions = new CurrentConditionsDisplay(weatherData);
        DisplayElement forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80.0, 65.0, 30.4);
        weatherData.setMeasurements(82.0, 70.0, 29.2);
        weatherData.setMeasurements(78.0, 90.0, 29.2);
    }
}