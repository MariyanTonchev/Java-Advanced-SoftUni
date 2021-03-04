package PetClinic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            switch (data[0]){
                case "Create":
                    if(data[1].equals("Pet")){
                        Pet pet = new Pet(data[2], Integer.parseInt(data[3]), data[4]);
                        pets.putIfAbsent(data[2], pet);
                    } else {
                        try {
                            Clinic clinic = new Clinic(data[2], Integer.parseInt(data[3]));
                            clinics.putIfAbsent(data[2], clinic);
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = data[1];
                    String clinicName = data[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "Release":
                    Clinic c = clinics.get(data[1]);
                    System.out.println(c.release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(data[1]).hasEmptyRoom());
                    break;
                case "Print":
                    String clinik = data[1];
                    Clinic klinik = clinics.get(clinik);
                    if(data.length == 2){
                        for (Pet pet1 : klinik.getPets()) {
                            if(pet1 == null){
                                System.out.println("Room empty");
                            } else {
                                System.out.println(pet1.toString());
                            }
                        }
                    } else {
                        int room = Integer.parseInt(data[2]);
                        klinik.printClinicRoomInfo(room);
                    }
                    break;
            }
        }
    }
}
