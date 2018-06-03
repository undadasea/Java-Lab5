package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class view {

    public static ArrayList<GridPane> gridList;
    public static ArrayList<ArrayList<TextField>> labList;
    public static ArrayList<String> OverViewList;

    public static void initializeGridList(){

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));

        Label Day = new Label("Day:");
        grid1.add(Day, 0, 0);
        TextField argDay = new TextField();
        grid1.add(argDay, 1, 0);

        Label Month = new Label("Month:");
        grid1.add(Month, 0, 1);
        TextField argMonth = new TextField();
        grid1.add(argMonth, 1, 1);

        Label Year = new Label("Year:");
        grid1.add(Year, 0, 2);
        TextField argYear = new TextField();
        grid1.add(argYear, 1, 2);

        ArrayList<TextField> textFieldList1 = new ArrayList<>();

        textFieldList1.add(argDay);
        textFieldList1.add(argMonth);
        textFieldList1.add(argYear);

        OverViewList = new ArrayList<>();
        OverViewList.add("Создать приложение, вычисляющее возраст , c 3 параметрами: " +
                "день, месяц , год( дата рождения), где месяц задается в виде строки: май или январь и т. п.\n" +
                "Результатом работы приложения должен быть возраст , выраженный в количестве лет, месяцев и дней на текущую дату.\n\nВывод:\n");

        /*******************************************************/
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.TOP_CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Label NumberOfThings = new Label("Number of things:");
        grid2.add(NumberOfThings, 0, 0);
        TextField argNumber = new TextField();
        grid2.add(argNumber, 1, 0);

        ArrayList<TextField> textFieldList2 = new ArrayList<>();

        textFieldList2.add(argNumber);

        OverViewList.add("Создать приложение с 6 классами и 3 интерфейсами. Интерфейсы : Игрушка с методом играть, " +
                "Дом с методом жить, Еда с методом есть .Классы - Мячик, Кукла ;Котлета, Бутерброд; Юрта, Коттедж; " +
                "Каждый класс реализует соответствующий интерфейс. Все интерфейсы унаследованы от интерфейса Предмет с методом цена.\n" +
                "В приложении создать массив объектов Предмет , состоящий из объектов всех классов " +
                "(количество элементов задано параметром ).Вывести все Предметы на дисплей. \n" +
                "Перебирая в цикле элементы массива Предмет, находить c помощью оператора instanceof те объекты, " +
                "которые реализуют интерфейс Еда.\n" +
                "Для каждого найденного элемента массива Предмет, реализующего интерфейс Еда, \n" +
                "выполнить метод интерфейса Еда и метод интерфейса Предмет. Вывести результаты поиска.\n\nВывод:\n");

        /*******************************************************/
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.TOP_CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        Label NumberOfIterations = new Label("Number of iterations:");
        grid3.add(NumberOfIterations, 0, 0);
        TextField argIter = new TextField();
        grid3.add(argIter, 1, 0);

        ArrayList<TextField> textFieldList3 = new ArrayList<>();

        textFieldList3.add(argIter);

        OverViewList.add("Напишите приложение с 2 потоками- производителем и потребителем, которые имеют разделяемую " +
                "статическую переменную- склад. То есть склад не является массивом!\n" +
                "Склад хранит целые числа от 0 до 100.\n" +
                "Производитель генерирует число от 0 до 100 и отправляет его на склад, выводя имя производителя и сгенеренное число.\n" +
                "Потребитель читает значение числа со склада, как только оно там появилось, и выводит на консоль " +
                "имя потребителя и полученное число.\n" +
                "Выполнить задание с использованием конструкции synchronized . \n" +
                "Не использовать в этом задании флаги для синхронизации потоков, а только методы wait и notify. \n" +
                "Также не использовать любые задержки для потоков после начала их работы в виде методов sleep, yield или wait c параметром.\n\nВывод:\n");

        /*******************************************************/
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.TOP_CENTER);
        grid4.setHgap(10);
        grid4.setVgap(10);
        grid4.setPadding(new Insets(25, 25, 25, 25));

        Label NumberOfWorkers = new Label("Number of workers:");
        grid4.add(NumberOfWorkers, 0, 0);
        TextField argWorkers = new TextField();
        grid4.add(argWorkers, 1, 0);
        Label NumberOfBoxes = new Label("Number of boxes:");
        grid4.add(NumberOfBoxes, 0, 1);
        TextField argBoxes = new TextField();
        grid4.add(argBoxes, 1, 1);

        ArrayList<TextField> textFieldList4 = new ArrayList<>();

        textFieldList4.add(argWorkers);
        textFieldList4.add(argBoxes);

        OverViewList.add("Выполнить многопотоковое приложение с 2 параметрами для нижеследующей задачи.\n" +
                "Работники(количество работников задано параметром) собирают яблоки в ящики(количество ящиков задано параметром). " +
                "Когда каждый работник соберет ящик , то он ждет пока остальные работники тоже соберут по одному ящику, далее он продолжает работу.\n" +
                "Работа заканчивается, когда все ящики будут собраны. Дополнительный работник координирует работу , " +
                "каждый работник сообщает ему о том, что собрал очередной ящик.\n" +
                "Использовать ограничения из задания 3. Выводить идентификатор работника вместе с номером ящика для каждого потока.\n\nВывод:\n");



        labList = new ArrayList<>();
        labList.add(textFieldList1);
        labList.add(textFieldList2);
        labList.add(textFieldList3);
        labList.add(textFieldList4);


        gridList = new ArrayList<>();
        gridList.add(grid1);
        gridList.add(grid2);
        gridList.add(grid3);
        gridList.add(grid4);
    }

    public static String[] readTextField(ArrayList<TextField> TextFieldArray){
        String[] array = new String[3];

        TextFieldArray.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                array[0] = TextFieldArray.get(0).getText();
            }
        });

        TextFieldArray.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                array[1] = TextFieldArray.get(1).getText();
            }
        });

        TextFieldArray.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                array[2] = TextFieldArray.get(2).getText();
            }
        });

        return array;
    }

    public static void getOutput(String address, String[] args, TextArea textArea, int LabNumber){
        ProcessBuilder proc = new ProcessBuilder();
        switch (LabNumber){
            case 1:
                proc = new ProcessBuilder("java", "-jar", address, args[0], args[1], args[2]);
                break;
            case 2:
            case 3:
                proc = new ProcessBuilder("java", "-jar", address, args[0]);
                break;
            case 4:
                proc = new ProcessBuilder("java", "-jar", address, args[0], args[1]);
                break;
        }
        try {
            Process process = proc.start();
            InputStreamReader stdout = new InputStreamReader(process.getInputStream());
            BufferedReader brStdout = new BufferedReader(stdout);
            String line, out = "";
            while((line = brStdout.readLine()) != null) {
                out += line + "\n";
            }
            textArea.setText(out);
            System.out.println(out);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
