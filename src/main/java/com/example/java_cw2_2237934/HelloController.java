package com.example.java_cw2_2237934;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class HelloController {
    ArrayList<Drivers> driverDetailsList = new ArrayList<>();
    Drivers racer;
    // should enter integer value for this
    String driverNumber;
    String name;

    int age;
    String ageInString;
    String team;
    String model;
    int points;
    String pointsInString;
    boolean errorValue = false;
    String deleteDriverNumber;

    // a list to save the details of the drivers which are extracted from the text file before deleting
    String[] driverDeleteList;
    String[] raceList;

    String updateDriverNumber;

    LocalDate raceDate;

    ArrayList<Race> raceStore = new ArrayList<>();

    String location;
    int position;
    @FXML
    private TextField numberTextField, DriverNameField, DriverAgeField, DriverTeamField, CarModelField, DriverCurrentPoints,
            deleteTextField, updateConfirmDriverNumberField, updateDriverNumberField, updateNameField, updateAgeField, updateTeamField, updateModelField, updatePointsField;
    @FXML
    Label driverNumberError, driverNameError, driverAgeerror, driverTeamError, carModelError,
            driverCurrentPointsError, detailsSaved, deletingDriverNameError, driverNotFoundUDD,
            UUDDrvierNumberError, UUDDrvierNameError, UUDDrvierAgeError, UUDDrvierTeamError, UUDDrvierModelError, UUDDrvierPointsError, UUDSuccess,
            SRRGenerator;

    @FXML
    TableView<Drivers> ChampionshipTable;

    @FXML
    TableColumn<Object, Object> driverNumberColounm;
    @FXML
    TableColumn<Object, Object> driverNameColounm;
    @FXML
    TableColumn<Object, Object> driverAgeColounm;
    @FXML
    TableColumn<Object, Object> driverTeamColounm;
    @FXML
    TableColumn<Object, Object> driverCarModelColounm;
    @FXML
    TableColumn<Object, Object> driverPointsColounm;

    @FXML
    TableView<Race> raceTable;

    @FXML
    TableColumn<Object, Object> LocationColounm;

    @FXML
    TableColumn<Object, Object> DateColounm;

    @FXML
    TableColumn<Object, Object> DriverPositionColounm;

    @FXML
    TableColumn<Object, Object> DriverNumberColounm;

    @FXML
    TableColumn<Object, Object> PointsColounm;

    // J unit testing

    // ADD function checking
    public boolean checkdriverNumberValid(String driverNumber) {
        if (driverNumber.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkdriverNameValid(String driverName) {
        if (driverName.isEmpty()) {
            return false;
        } else if (!driverName.matches("[a-zA-Z ]+")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkDriverAgeValid(String ageInString) {
        if (ageInString.isEmpty()) {
                return false;
        }else if(!ageInString.matches("\\d+")) {
            return false;
        }
        return true;
    }

    public boolean checkDriverTeamValid(String team){
        if (team.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkDriverModelValid(String model){
        if (model.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkDriverPointsValid(String pointsInString){
        if (pointsInString.isEmpty()) {
            return false;
        }else if(!pointsInString.matches("\\d+")) {
            return false;
        }
        return true;
    }

    // delete testing

    public boolean checkdriverNumberForDelete(String driverNumber) {
        if (driverNumber.isEmpty()) {
            return false;
        }
        return true;
    }

    // update testing

    public boolean checkdriverNumberValidForUpdate(String driverNumber) {
        if (driverNumber.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkdriverNameValidForUpdate(String driverName) {
        if (driverName.isEmpty()) {
            return false;
        } else if (!driverName.matches("[a-zA-Z ]+")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkDriverAgeValidForUpdate(String ageInString) {
        if (ageInString.isEmpty()) {
            return false;
        }else if(!ageInString.matches("\\d+")) {
            return false;
        }
        return true;
    }

    public boolean checkDriverTeamValidForUpdate(String team){
        if (team.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkDriverModelValidForUpdate(String model){
        if (model.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkDriverPointsValidForUpdate(String pointsInString){
        if (pointsInString.isEmpty()) {
            return false;
        }else if(!pointsInString.matches("\\d+")) {
            return false;
        }
        return true;
    }

    // when user click on Adding button this new fxml will load
    public void onAddButtonClick() throws IOException {
        // creating a new stage
        Stage addScreen = new Stage();
        // a new FXML file is loaded
        Parent root = FXMLLoader.load(getClass().getResource("add-screen.fxml"));
        // setting the title for the stage
        addScreen.setTitle(" Add Screen ");
        // a new scene is created
        addScreen.setScene(new Scene(root));
        // the new scene is displayed
        addScreen.show();
    }

    public void onConfirmButtonClick() throws IOException {
        // collecting inputs from the user

        driverNumber = numberTextField.getText();
        name = DriverNameField.getText();
        ageInString = DriverAgeField.getText();
        team = DriverTeamField.getText();
        model = CarModelField.getText();
        pointsInString = DriverCurrentPoints.getText();


        //validating process

        if(driverNumber.isEmpty()){
            driverNumberError.setText("Driver number is empty.");
            // error found
            errorValue = true;
        }


        if (name.isEmpty()) {
            driverNameError.setText("Driver name is empty");
            errorValue = true;
        } else if (!name.matches("[a-zA-Z ]+")) {
            driverNameError.setText("You have entered an invalid data type for name");
            errorValue = true;
        }


        if (ageInString.isEmpty()) {
            driverAgeerror.setText("Age is empty");
            errorValue = true;
            //  \\d+ means one or more numeric digits
        } else if(!ageInString.matches("\\d+")) {
            driverAgeerror.setText("You have entered an invalid data type for age");
            errorValue = true;
        }


        if (team.isEmpty()) {
            driverTeamError.setText("Team is empty");
            errorValue = true;
        }

        if (model.isEmpty()) {
            carModelError.setText("Model is empty");
            errorValue = true;
        }

        if (pointsInString.isEmpty()) {
            driverCurrentPointsError.setText("Driver Points is empty");
            errorValue = true;
            // checking whether user enters only numbers
        } else if (!pointsInString.matches("\\d+")){
            driverCurrentPointsError.setText("You have entered an invalid data type for points");
            errorValue = true;
        } else {
            points = Integer.parseInt(pointsInString);
        }

        if (!errorValue) {
            racer = new Drivers(driverNumber, name, age, team, model, points);
            driverDetailsList.add(racer);
            detailsSaved.setText("You have successfully saved details");
        }

        // opening the file in append mode
        FileWriter fileWriter = new FileWriter("driver_details.txt", true);
        for (Drivers racer : driverDetailsList) {
            fileWriter.write(racer.getDriverNumber() + "/" + racer.getName() + "/" + racer.getAge() + "/" + racer.getTeam() +
                    "/" + racer.getModel() + "/" + racer.getPoints() + "\n");
        }
        fileWriter.close();
        // if driverDetailsList not cleared, when running on next time details will overwrite
        driverDetailsList.clear();
        // clearing all text fields
        numberTextField.clear();
        DriverNameField.clear();
        DriverAgeField.clear();
        DriverTeamField.clear();
        DriverCurrentPoints.clear();
        CarModelField.clear();

    }




    public void onDeleteButtonClick() throws IOException {

        // creating a new stage
        Stage deleteScreen = new Stage();
        // a new FXML file is loaded
        Parent root = FXMLLoader.load(getClass().getResource("delete-screen.fxml"));
        // setting the title for the stage
        deleteScreen.setTitle(" Delete Screen ");
        // a new scene is created
        deleteScreen.setScene(new Scene(root));
        // the new scene is displayed
        deleteScreen.show();

    }

    // deleting driver details

    public void onDeleteConfirmButtonClick() throws IOException {
        // the driver number of the driver to be deleted is taken
        deleteDriverNumber = deleteTextField.getText();
        errorValue = false;

        // checks if the field is empty
        if(deleteDriverNumber.isEmpty()){
            deletingDriverNameError.setText("Driver number is empty");
            errorValue = true;
        }

        if(!errorValue) {
            // a buffered reader is opened to read the text file, BufferedReader will read the file line by line
            BufferedReader bReader = new BufferedReader(new FileReader("driver_details.txt"));
            String row;
            boolean driverDeleted = false;
            // while loop to read the text file until a blank line is found
            while ((row = bReader.readLine()) != null) {
                // we state how the elements are split in the text file
                driverDeleteList = row.split("/");

                //we assign the parameters to the respective element number in the list
                driverNumber = driverDeleteList[0];
                name = driverDeleteList[1];
                age = Integer.parseInt(driverDeleteList[2]);
                team = driverDeleteList[3];
                model = driverDeleteList[4];
                points = Integer.parseInt(driverDeleteList[5]);

                // if the driverNumber has been identified, then the driver is deleted
                if(deleteDriverNumber.equals(driverNumber)) {
                    deletingDriverNameError.setText(" Driver has been deleted!");
                    driverDeleted = true;
                } else {
                    racer = new Drivers(driverNumber, name, age, team, model, points);
                    // the parameters are written back onto the list
                    driverDetailsList.add(racer);
                }
            }
            // the buffered reader is closed
            bReader.close();
            if (!driverDeleted) {
                deletingDriverNameError.setText("Driver not found");
            }

            // a file writer is opened to edit the new changes
            FileWriter fileWriter = new FileWriter("driver_details.txt");
            // contents of the list are written onto the text file in the format specified
            for (Drivers racer : driverDetailsList) {
                fileWriter.write(racer.getDriverNumber() + "/" + racer.getName() + "/" + racer.getAge() + "/" + racer.getTeam() +
                        "/" + racer.getModel() + "/" + racer.getPoints() + "\n");
            }
            // the file writer is closed
            fileWriter.close();
            // clearing text fields
            deleteTextField.clear();
            // the list is cleared
            driverDetailsList.clear();
        }
    }
    //
    public void onUpdateButtonClick() throws IOException {

        // creating a new stage
        Stage updateScreen = new Stage();
        // a new FXML file is loaded
        Parent root = FXMLLoader.load(getClass().getResource("update-screen(1).fxml"));
        // setting the title for the stage
        updateScreen.setTitle("Driver Number Checking");
        // a new scene is created
        updateScreen.setScene(new Scene(root));
        // the new scene is displayed
        updateScreen.show();
    }

    public void onDriverNumberUpdateButtonClick() throws IOException {
        updateDriverNumber =updateConfirmDriverNumberField.getText();

        if(updateDriverNumber.isEmpty()){
            driverNotFoundUDD.setText("Driver number is empty");
            errorValue = true;
        }

        if(!errorValue) {
            // a buffered reader is opened to read the text file
            BufferedReader bReader = new BufferedReader(new FileReader("driver_details.txt"));
            String row;
            boolean driverDeleted = false;
            // while loop to read the text file until a blank line is found
            while ((row = bReader.readLine()) != null) {
                // we state how the elements are split in the text file
                driverDeleteList = row.split("/");

                //we assign the parameters to the respective element number in the list
                if (driverDeleteList.length >= 6) {
                    driverNumber = driverDeleteList[0];
                    name = driverDeleteList[1];
                    age = Integer.parseInt(driverDeleteList[2]);
                    team = driverDeleteList[3];
                    model = driverDeleteList[4];
                    points = Integer.parseInt(driverDeleteList[5]);
                }

                // if the driverNumber has been identified, then the driver can be updated
                if(driverNumber.equals(updateDriverNumber)) {
                    driverNotFoundUDD.setText("Driver Found, next enter updated details of the driver");
                    driverDeleted = true;

                    // creating a new stage
                    Stage updateScreenTwo = new Stage();
                    // a new FXML file is loaded
                    Parent root = FXMLLoader.load(getClass().getResource("update-screen(2).fxml"));
                    // setting the title for the stage
                    updateScreenTwo.setTitle("Driver Number Checking");
                    // a new scene is created
                    updateScreenTwo.setScene(new Scene(root));
                    // the new scene is displayed
                    updateScreenTwo.show();
                    // the file writer is closed

                    //clearing text fields
                    updateConfirmDriverNumberField.clear();
                    //clearing driverDetailsList so that won't overwrite on the next time.

                } else {
                    racer = new Drivers(driverNumber, name, age, team, model, points);
                    // the parameters are written back onto the list
                    driverDetailsList.add(racer);
                }
            }
            if (!driverDeleted) {
                driverNotFoundUDD.setText("Driver not found");
            }
            // the buffered reader is closed
            bReader.close();

            // a file writer is opened to edit the new changes
            FileWriter fileWriter = new FileWriter("driver_details.txt");
            // contents of the list are written onto the text file in the format specified
            for (Drivers racer : driverDetailsList) {
                fileWriter.write(racer.getDriverNumber() + "/" + racer.getName() + "/" + racer.getAge() + "/" + racer.getTeam() +
                        "/" + racer.getModel() + "/" + racer.getPoints() + "\n");
            }
            fileWriter.close();
            driverDetailsList.clear();
        }
    }

    public void onUpdateConfirmButtonClick() throws IOException {

        driverNumber = updateDriverNumberField.getText();
        name = updateNameField.getText();
        ageInString = updateAgeField.getText();
        team = updateTeamField.getText();
        model = updateModelField.getText();
        pointsInString = updatePointsField.getText();


        //validating process

        if(driverNumber.isEmpty()){
            UUDDrvierNumberError.setText("Driver number is empty");
            // error found
            errorValue = true;
        }

        if (name.isEmpty()) {
            driverNameError.setText("Driver name is empty");
            errorValue = true;
        } else if (!name.matches("[a-zA-Z ]+")) {
            driverNameError.setText("You have entered an invalid data type for name");
            errorValue = true;
        }

        if (ageInString.isEmpty()) {
            driverAgeerror.setText("Age is empty");
            errorValue = true;
            //  \\d+ means one or more numeric digits
        } else if(!ageInString.matches("\\d+")) {
            driverAgeerror.setText("You have entered an invalid data type for age");
            errorValue = true;
        }

        if (team.isEmpty()) {
            UUDDrvierTeamError.setText("Team is empty");
            errorValue = true;
        }

        if (model.isEmpty()) {
            UUDDrvierModelError.setText("Model is empty");
            errorValue = true;
        }

        if (pointsInString.isEmpty()) {
            UUDDrvierPointsError.setText("Driver Points is empty");
            errorValue = true;
            // checking whether user enters only numbers
        } else if (!pointsInString.matches("\\d+")){
            UUDDrvierPointsError.setText("You have entered an invalid data type for points");
            errorValue = true;
        } else {
            points = Integer.parseInt(pointsInString);
        }
        if (!errorValue) {
            racer = new Drivers(driverNumber, name, age, team, model, points);
            driverDetailsList.add(racer);
            UUDSuccess.setText("You have successfully update details");
        }
        FileWriter updateDriverDetails = new FileWriter("driver_details.txt", true);
        for (Drivers racer : driverDetailsList) {
            updateDriverDetails.write(racer.getDriverNumber() + "/" + racer.getName() + "/" + racer.getAge() + "/" + racer.getTeam() +
                    "/" + racer.getModel() + "/" + racer.getPoints()+ "\n");
        }
        updateDriverDetails.close();

        //clearing text fields
        updateDriverNumberField.clear();
        updateNameField.clear();
        updateAgeField.clear();
        updateTeamField.clear();
        updateModelField.clear();
        updatePointsField.clear();
        //clearing driverDetailsList so that won't overwrite on the next time.
        driverDetailsList.clear();

    }
    public void onStandingsButtonClick() throws IOException {

        // creating a new stage
        Stage addScreen = new Stage();
        // a new FXML file is loaded
        Parent root = FXMLLoader.load(getClass().getResource("championship-Table.fxml"));
        // setting the title for the stage
        addScreen.setTitle(" Sorted Screen ");
        // a new scene is created
        addScreen.setScene(new Scene(root));
        // the new scene is displayed
        addScreen.show();

    }
    public void onLoadButtonClick() throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader("driver_details.txt"));
        String row;
        // while loop to read the text file until a blank line is found
        while ((row = bReader.readLine()) != null) {
            driverDeleteList = row.split("/");

            //we assign the parameters to the respective element number in the list
            driverNumber = driverDeleteList[0];
            name = driverDeleteList[1];
            age = Integer.parseInt(driverDeleteList[2]);
            team = driverDeleteList[3];
            model = driverDeleteList[4];
            points = Integer.parseInt(driverDeleteList[5]);


            racer = new Drivers(driverNumber, name, age, team, model, points);
            driverDetailsList.add(racer);

            // sorting process
            Drivers tempStore;
            int lengthOfList = driverDetailsList.size();
            for(int i=0 ; i<lengthOfList-1; i++) {
                for (int k = 0; k < lengthOfList - i - 1; k++) {
                    if (driverDetailsList.get(k).getPoints() < driverDetailsList.get(k + 1).getPoints()) {
                        //swapping part
                        // temporarily storing the first drivers details
                        tempStore = driverDetailsList.get(k);
                        // the details of the second driver are stored in the location of the first driver
                        driverDetailsList.set(k, driverDetailsList.get(k + 1));
                        // the temporary details are stored in the second driver details position
                        driverDetailsList.set(k + 1, tempStore);
                    }
                }
            }

        }

        // sorted driver details is stored in ObservableList
        // this will show in the table
        ObservableList<Drivers> sortedObservableList = FXCollections.observableArrayList(driverDetailsList);
        driverNumberColounm.setCellValueFactory(new PropertyValueFactory<>("driverNumber"));
        driverNameColounm.setCellValueFactory(new PropertyValueFactory<>("name"));
        driverAgeColounm.setCellValueFactory(new PropertyValueFactory<>("age"));
        driverTeamColounm.setCellValueFactory(new PropertyValueFactory<>("team"));
        driverCarModelColounm.setCellValueFactory(new PropertyValueFactory<>("model"));
        driverPointsColounm.setCellValueFactory(new PropertyValueFactory<>("points"));
        ChampionshipTable.setItems(sortedObservableList);
        driverDetailsList.clear();
    }

    public void onSrrButtonClick() throws IOException{
        // creating a new stage
        Stage addScreen = new Stage();
        // a new FXML file is loaded
        Parent root = FXMLLoader.load(getClass().getResource("SRR-screen.fxml"));
        // setting the title for the stage
        addScreen.setTitle(" Random Race  Generator Screen ");
        // a new scene is created
        addScreen.setScene(new Scene(root));
        // the new scene is displayed
        addScreen.show();
    }

    public void onGenerateButtonClick() throws IOException {
        // generating a random location
        String[] locationList = {"Nyirád", "Höljes","Montalegre", "Barcelona", "Rīga", "Norway"};
//        this will generate a random number from the location list
        int locationGenerator = new Random().nextInt(locationList.length);
        // the random index obtained above is checked on the list of locations and the location is obtained
        String randomLocation = locationList[locationGenerator];
//      this will look for the generated dates and will generate new date which is not in Random Race file
        ArrayList<LocalDate> existingDate = new ArrayList<>();
        for (Race race: raceStore){
            existingDate.add(race.getRaceDate());
        }
        do {
            // generating a random date
            Random dateGenerator = new Random();
//      day, month and year are generating randomly
            int monthOfRace = dateGenerator.nextInt(1) + 4;
            int dayOfRace = dateGenerator.nextInt(30) + 1;
            int yearOfRace = dateGenerator.nextInt(1) + 2024;
//      this generates the random date for the race
            raceDate = LocalDate.of(yearOfRace,monthOfRace,dayOfRace);
        } while (existingDate.contains(raceDate));

        BufferedReader bReader = new BufferedReader(new FileReader("driver_details.txt"));
        String row;
        // while loop to read the text file until a blank line is found
        while ((row = bReader.readLine()) != null) {
            // we state how the elements are split in the text file
            driverDeleteList = row.split("/");

            //we assign the parameters to the respective element number in the list
            driverNumber = driverDeleteList[0];
            name = driverDeleteList[1];
            age = Integer.parseInt(driverDeleteList[2]);
            team = driverDeleteList[3];
            model = driverDeleteList[4];
            points = Integer.parseInt(driverDeleteList[5]);

            racer = new Drivers(driverNumber, name, age, team, model, points);
            driverDetailsList.add(racer);

        }
        Collections.shuffle(driverDetailsList);
        // this will iterate the loop until drivers gets end

        // updated driver points will be write on driver_details file
        // 1st place
        Drivers driver1 = driverDetailsList.get(0);
        driver1.setPoints(driver1.getPoints() + 10);
        driverDetailsList.set(0, driver1);
        // 2nd place
        Drivers driver2 = driverDetailsList.get(1);
        driver2.setPoints(driver2.getPoints() + 7);
        driverDetailsList.set(1, driver2);
        // 3rd place
        Drivers driver3 = driverDetailsList.get(2);
        driver3.setPoints(driver3.getPoints() + 5);
        driverDetailsList.set(2, driver3);

        FileWriter fileWriter = new FileWriter("driver_details.txt");
        for (Drivers racer : driverDetailsList) {
            fileWriter.write(racer.getDriverNumber() + "/" + racer.getName() + "/" + racer.getAge() + "/" + racer.getTeam() +
                    "/" + racer.getModel() + "/" + racer.getPoints()+ "\n");
        }
        fileWriter.close();
        int racePosition = 1;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("driver_details.txt"));
        String entry;
        while ((entry = bufferedReader.readLine())!= null){
            if(racePosition < 4){
                driverDeleteList = entry.split("/");
                //we assign the parameters to the respective element number in the list
                driverNumber = driverDeleteList[0];
                points = Integer.parseInt(driverDeleteList[5]);
                Race randomRace = new Race(randomLocation, raceDate, racePosition, driverNumber, points);
                raceStore.add(randomRace);
                racePosition++;
            }
        }
        int positionPoints;
        // adding points to first three drivers
        for(int count = 0; count < raceStore.size(); count++){
            // when count equals to 0,  first race's last index will be assigned to positionPoints
            positionPoints = raceStore.get(count).getDriverPosition();
            if(positionPoints == 3){
            //we are getting the current points of the driver and setting the given points to it
                raceStore.get(count).setDriverPoints(raceStore.get(count).getDriverPoints() + 5);
            } else if (positionPoints == 2) {
                raceStore.get(count).setDriverPoints(raceStore.get(count).getDriverPoints()  + 7);
            }
            else if(positionPoints == 1){
                raceStore.get(count).setDriverPoints(raceStore.get(count).getDriverPoints() + 10);
            }
        }

        FileWriter writer = new FileWriter("Random Race.txt", true);
        for(Race randomlyGeneratedRace: raceStore){
            writer.write(randomlyGeneratedRace.getLocation() + "/" + randomlyGeneratedRace.getRaceDate()+ "/" +randomlyGeneratedRace.getDriverPosition()
                    + "/" + randomlyGeneratedRace.getDriverNumber()+ "/" +randomlyGeneratedRace.getDriverPoints()+"\n");
        }
        writer.close();
        driverDetailsList.clear();
        raceStore.clear();
        SRRGenerator.setText("Race Generated, look for Random Race file");

    }
    public void onRandomRaceButtonClick() throws IOException {

        // creating a new stage
        Stage addScreen = new Stage();
        // a new FXML file is loaded
        Parent root = FXMLLoader.load(getClass().getResource("race-screen.fxml"));
        // setting the title for the stage
        addScreen.setTitle("Random Race Screen");
        // a new scene is created
        addScreen.setScene(new Scene(root));
        // the new scene is displayed
        addScreen.show();

    }
    public void onRacesLoadButtonClick() throws IOException {

        BufferedReader bReader = new BufferedReader(new FileReader("Random Race.txt"));
        String row;
        ObservableList<Race> raceObservableList = FXCollections.observableArrayList();

        while ((row = bReader.readLine()) != null) {
            raceList = row.split("/");

            //we assign the parameters to the respective element number in the list
            location = raceList[0];
            raceDate = LocalDate.parse(raceList[1]);
            position = Integer.parseInt(raceList[2]);
            driverNumber = raceList[3];
            points = Integer.parseInt(raceList[4]);

            Race randomRace = new Race(location, raceDate, position, driverNumber, points);
            raceStore.add(randomRace);
        }

        // sorting using randomly generated date
        for (int i=0; i < raceStore.size(); i++) {
            for (int j=i+1; j < raceStore.size(); j++) {
                LocalDate di = raceStore.get(i).getRaceDate();
                LocalDate dj = raceStore.get(j).getRaceDate();
                if (dj.isAfter(di)) {
                    Race temp = raceStore.get(i);
                    raceStore.set(i, raceStore.get(j));
                    raceStore.set(j, temp);
                }
            }
        }
        raceObservableList.addAll(raceStore);
        LocationColounm.setCellValueFactory(new PropertyValueFactory<>("location"));
        DateColounm.setCellValueFactory(new PropertyValueFactory<>("raceDate"));
        DriverPositionColounm.setCellValueFactory(new PropertyValueFactory<>("driverPosition"));
        DriverNumberColounm.setCellValueFactory(new PropertyValueFactory<>("driverNumber"));
        PointsColounm.setCellValueFactory(new PropertyValueFactory<>("driverPoints"));
        raceTable.setItems(raceObservableList);
        raceStore.clear();
    }
}