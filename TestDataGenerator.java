package com.example;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;
import com.github.javafaker.Faker;
import java.io.FileWriter;


import java.io.IOException;


public class TestDataGenerator{

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Faker faker = new Faker();
        List<String> pick = new ArrayList<>();

        System.out.println("How many test data records would you like to generate?: ");
        int records = scanner.nextInt();
        scanner.nextLine();

        System.out.println("1. Name \n2. Age \n3. Code \n4. Phone Number \n5. Address \n6. Postal Code \n7. Company \n8. Email \n9. University \n10. Job");
        System.out.println("Please Choose all the Data you would like to generate, separate your options with spaces (eg 1 2 3 4): ");
        String [] choices = scanner.nextLine().split(" ");

        System.out.println("What is the name of the file you would like the store these values in (eg test): ");
        String fileName = scanner.nextLine();


        for(int i=0; i < records; i++){
            StringBuilder datas = new StringBuilder();

            for(String choice : choices){
                switch (choice){
                    //depending on the option chosen it generates a certain test data.
                    case "1":
                        String name = faker.name().fullName();
                        datas.append(name).append(", ");
                        break;

                    case "2":
                        int age = faker.number().numberBetween(18, 90);
                        datas.append(age).append(", ");
                        break;

                    case "3":
                        String code = faker.code().isbn10();
                        datas.append(code).append(", ");
                        break;

                    case "4":
                        String phone = faker.phoneNumber().cellPhone();
                        datas.append(phone).append(", ");
                        break;

                    case "5":
                        String addy = faker.address().fullAddress();
                        datas.append(addy).append(", ");
                        break;

                    case "6":
                        String postal = faker.address().zipCode();
                        datas.append(postal).append(", ");
                        break;

                    case "7":
                        String company = faker.company().name();
                        datas.append(company).append(", ");
                        break;

                    case "8":
                        String email = faker.internet().emailAddress();
                        datas.append(email).append(", ");
                        break;

                    case "9":
                        String uni = faker.university().name();
                        datas.append(uni).append(", ");
                        break;

                    case "10":
                        String job = faker.job().title();
                        datas.append(job).append(", ");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
            pick.add(datas.toString());
            System.out.println("Data " + (i+1) + ": " + datas.toString());
        }



        try (FileWriter write = new FileWriter(fileName)){
            StringBuilder header = new StringBuilder();

            for (String choice : choices){
                switch(choice){
                    case "1":
                        header.append("Name, ");
                        break;

                    case "2":
                        header.append("Age, ");
                        break;

                    case "3":
                        header.append("Code, ");
                        break;

                    case "4":
                        header.append("Phone Number, ");
                        break;

                    case "5":
                        header.append("Address, ");
                        break;

                    case "6":
                        header.append("Postal Code, ");
                        break;

                    case "7":
                        header.append("Company, ");
                        break;

                    case "8":
                        header.append("Email, ");
                        break;

                    case "9":
                        header.append("University, ");
                        break;

                    case "10":
                        header.append("Job, ");
                        break;
                }
            }

            write.write(header.toString() + "\n");
            for (String record : pick){
                write.write(record + "\n");
            }

            System.out.println("Done Generating to " + fileName);
        }
        catch (IOException e){
            System.out.println("Error occured during generation");
            e.printStackTrace();
        }
        scanner.close();
    }


}
