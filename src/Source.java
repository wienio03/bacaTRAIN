//Wienczyslaw Wlodyga
import java.util.Scanner;
//program sklada sie z trzech klas Carriage(klasa wagonu), Train(klasa pociagu) oraz TrainsList(klasa listy pociagow)
//klasy zawieraja konstruktory i metody np. wstawiania usuwania elementow oraz odnajdywania ich w liscie
//metody wymagajace dzialania w czasie O(n) takie jak np. Display() dzialaja w czasie O(n), natomiast pozostale operacje
//wykonywane sa w czasie O(1) wymagajac momentami tworzenia nowego obiektu danej klasy
class Carriage{
    Carriage prev;
    String name;
    Carriage next;
    //konstruktor wagonu
    public Carriage(String name){
        this.name = name;
        next = null;
        prev = null;
    }
}
class Train {
    Carriage first;
    Carriage last;
    String name;
    Train next;
    boolean rev;

    //konstruktor pociagu czyli listy wagonow
    public Train(String trainName, String firstName) {
        first = new Carriage(firstName);
        name = trainName;
        last = first;
        next = null;
        rev = false;
    }

    public void Reverse() {
        rev = !rev;
        Carriage tmp = first;
        first = last;
        last = tmp;

    }

    public void Display() {
        Carriage tmp = first;
        Carriage tmpPrev = tmp;
        System.out.print(this.name + ": ");
        while (tmp != null) {
            System.out.print(tmp.name + " ");
            if(tmpPrev == tmp.prev)
                tmp = tmp.next;
            else if(tmpPrev == tmp.next)
                tmp = tmp.prev;
            else{
                if(this.rev){
                    tmp = tmp.next;
                }
                else
                    tmp = tmp.prev;
            }
        }
        System.out.print("\n");
    }
    void DeleteFirst(){

    }
    void DeleteLast(){

    }
}


class TrainsList{
    Train first;
    //konstruktor listy pociagow
    public TrainsList(){
        first = null;
    }
    
}
public class Source {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sets = scanner.nextInt();
        scanner.nextLine();
        int commands = scanner.nextInt();
        scanner.nextLine();
        String command;
        String trainID1;
        String trainID2;
        String trainID;
        String carriageID;
        for(int j = 0; j < sets; j++) {
            TrainsList list = new TrainsList();
            for (int i = 0; i < commands; i++) {
                command = scanner.next();
                if (command.equals("New")) {
                    trainID1 = scanner.next();
                    carriageID = scanner.next();
                    list.Insert(trainID1, carriageID);
                } else if (command.equals("InsertFirst")) {
                    trainID = scanner.next();
                    carriageID = scanner.next();
                    Train tmp = list.locate(trainID);
                    tmp.InsertFirst(carriageID);
                } else if (command.equals("InsertLast")) {
                    trainID = scanner.next();
                    carriageID = scanner.next();
                    Train tmp = list.locate(trainID);
                    tmp.InsertLast(carriageID);
                } else if (command.equals("Display")) {
                    trainID = scanner.next();
                    System.out.println(list.DisplayTrain(trainID));
                } else if (command.equals("TrainsList")) {
                    System.out.println(list.DisplayTrainsList());
                } else if (command.equals("Reverse")) {
                    trainID = scanner.next();
                    list.ReverseTrain(trainID);
                } else if (command.equals("Union")) {
                    trainID1 = scanner.next();
                    trainID2 = scanner.next();
                    list.TrainUnion(trainID1, trainID2);
                } else if (command.equals("DelFirst")) {
                    trainID1 = scanner.next();
                    trainID2 = scanner.next();
                    list.DelFirst(trainID1, trainID2);
                } else if (command.equals("DelLast")) {
                    trainID1 = scanner.next();
                    trainID2 = scanner.next();
                    list.DelLast(trainID1, trainID2);
                }
            }
        }
    }
}
//TESTY:
/*
testy z tresci:
1
23
New T1 W1
InsertLast T1 W2
Display T1
InsertFirst T1 W0
Display T1
DelFirst T1 T2
Display T1
Display T2
DelLast T1 T3
Display T1
Display T3
TrainsList
New T4 Z1
InsertLast T4 Z2
Reverse T4
Display T4
Union T3 T4
Display T3
TrainsList
Union T3 T2
Display T3
Reverse T3
Display T3

testy wlasne:
1
16
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
New T2 W6
InsertLast T2 W5
InsertLast T2 W4
Reverse T2
New T3 W8
InsertLast T3 W7
Reverse T3
New T4 W9
InsertLast T4 W10
Union T1 T2
Union T3 T4
Union T1 T3
Display T1
1
26
New T1 W1
InsertLast T1 W2
InsertLast T1 W3
New T2 W6
InsertLast T2 W5
InsertLast T2 W4
Reverse T2
New T3 W8
InsertLast T3 W7
Reverse T3
New T4 W9
InsertLast T4 W10
Union T1 T2
Union T3 T4
Union T1 T3
Display T1
DelLast T1 T2
DelLast T1 T3
DelLast T1 T4
DelLast T1 T5
DelLast T1 T6
DelLast T1 T7
DelLast T1 T8
DelLast T1 T9
DelLast T1 T10
Display T1
 */