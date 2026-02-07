/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.petcare_sheduler;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author danuja
 */
public class PetCare_Sheduler {

    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, Pet> pets = new HashMap<>();

    public static void main(String[] args) {
        LoadData();
        System.out.println(pets.size());

        while (true) {
            System.out.println("1.Register pets");
            System.out.println("2.Schedule appointments");
            System.out.println("3.Store data");
            System.out.println("4.Display records");
            System.out.println("5.Generate Reports");
            System.out.println("Enter choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    RegisterPet();
                    break;
                case "2":
                    SheduleAppoinments();
                    break;
                    
                case "3":
                    PetsToFile();
                    break;
                    
                case "4":
                    DisplayData();
                    break;
                    

            }

        }

    }
    private static void DisplayData(){
        System.out.println(pets.size());
        for(Pet pet: pets.values() ){
            System.out.println(pet.getName());
        }
    }

    private static void RegisterPet() {
        System.out.println("Enter the PetID: ");
        String petID = sc.nextLine();
        if (isBlank(petID)) {
            System.out.println("Inavlid input");
            return;

        }
        if(pets.containsKey(petID)){
            System.out.println("PetId is already exists");
            return;
        }
        petID = petID.trim();
        
        

        System.out.println("Enter the Name: ");
        String Name = sc.nextLine();
        if (isBlank(Name)) {
            System.out.println("Inavlid input");
            return;

        }
        Name = Name.trim();

        System.out.println("Enter the breed: ");
        String breed = sc.nextLine();
        if (isBlank(breed)) {

            System.out.println("Inavlid input");
            return;

        }
        breed = breed.trim();

        System.out.println("Enter the PetAge: ");
        String value = sc.nextLine();
        if (!Validint(value)) {
            System.out.println("Invalid age");
            return;
        }

        int age = Integer.parseInt(value.trim());

        System.out.println("Enter the OwnerName: ");
        String OwnerName = sc.nextLine();
        if (isBlank(OwnerName)) {
            System.out.println("Inavlid input");
            return;

        }
        OwnerName = OwnerName.trim();

        System.out.println("Enter the Contactinfo: ");
        String contactinfo = sc.nextLine();
        if (isBlank(contactinfo)) {
            System.out.println("Inavlid input");
            return;

        }
        contactinfo = contactinfo.trim();

        Pet newpet = new Pet(petID, Name, breed, age, OwnerName, contactinfo);
        pets.put(petID, newpet);

        System.out.println("Pet Registered Successfully " + newpet.getRegisterdDate());

    }

    private static void SheduleAppoinments() {
        System.out.println("Enter the PetID: ");
        String petid = sc.nextLine();
        if (isBlank(petid)) {
            System.out.println("Invalid petID");
            return;

        }
        petid = petid.trim();
        if (!pets.containsKey(petid)) {

            System.out.println("petID dosent exists");
            return;

        }
        System.out.println("Appointment type (for example, vet visit, vaccination, grooming)");
        String appointment = sc.nextLine();
        if (isBlank(appointment)) {
            System.out.println("Invalid input");
            return;
        }
        appointment = appointment.trim();
       
        LocalDate date_time =  DateValidate(sc, "Enter the appoinment Date and time (dd/MM/yyyy hh:mm a) ");
        if(date_time == null){
            return;
        }

        System.out.println("Enter Note");
        String note = sc.nextLine();
        Pet pet = pets.get(petid);
        pet.getAppoinments().add(new Appoinment(appointment, note,date_time));
        System.out.println("Sucessfully added appoinment to " + pet.getOwnername());

    }
    private static void PetsToFile() {
        try {
            // Create a FileOutputStream to write to the file named "pet.ser"
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("pet.ser")
            );
            // Write the entire pets map to the file
            out.writeObject(pets);
            System.out.println("data is saved to file");

            // If successful, no message is printed here — could add confirmation if you like
        } catch (IOException e) {
            // Task 8
            // If something goes wrong while saving, print an error message
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    private static LocalDate DateValidate(Scanner input, String message) {

        while (true) {
            System.out.println(message);
            String value = input.nextLine();
            if(isBlank(value)){
                System.out.println("Invalid input");
                continue;
            }
            else if(value.equals("exit")){
                return null;
                
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
            
            try {
                LocalDate date = LocalDate.parse(value, formatter);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date");
            }
        }

      
    }
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    private static void LoadData(){
        
        try (
                // Open an ObjectInputStream to read from the file pet.ser"
            
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("pet.ser"))
        ) 
        {
            // Read the object from the file and cast it back to the correct type
            pets = (Map<String, Pet>) in.readObject();

            // Confirmation message to let the user know data was loaded
            System.out.println("pets data loaded.");
        } catch (FileNotFoundException e) {
            // Task 8
            // If the file doesn't exist yet, that's okay — start with empty data
            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            // Handle other errors, like if the file is corrupted or unreadable
            System.out.println("Error loading data: " + e.getMessage());
        }
        
        
    }

    //validation userInputs 
    private static boolean isBlank(String message) {

        return (message == null || message.trim().isEmpty());

    }

    private static boolean Validint(String message) {
        if (message == null || message.trim().isEmpty()) {
            return false;
        }
        try {

            Integer.parseInt(message.trim());
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

}
