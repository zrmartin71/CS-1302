package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import martian_stuff.*;

public class Main extends Application {
	
	protected Label selectorPrompt, setId, setVol, removeMartianLabel, makeSpeakLabel;
	protected Label userFileLable, groupTeleportLabel, userWriterFileLable;
	protected ComboBox<String> cmbMartians, cmbUsrMartians;
	protected CheckBox ckbHasEsp, ckbIsVegetarian;
	protected RadioButton rbGoToMars;
	TextArea txaMartianDisplay, txaMartianFileDisplay;
	TextField txfSetId, txfSetVol, txfRemoveMartian, txfSpeak, txfUserFile, txfGroupTeleport;
	TextField txfUserWriterFile;
	MartianManager createdMartians = new MartianManager();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane anchorRootPane = new AnchorPane();
			
			TabPane tabMartianPane = new TabPane();
			Tab tab1 = new Tab("Martian Maker");
			GridPane gridMartianPane = buildGuiPane();
			tab1.setContent(gridMartianPane);
			Tab tab2 = new Tab("Martians from file");
			GridPane gridMartianFilePane = buildMartianFilePane();
			tab2.setContent(gridMartianFilePane);
			tabMartianPane.getTabs().addAll(tab1, tab2);
			anchorRootPane.getChildren().addAll(tabMartianPane);
			
			Scene scene = new Scene(anchorRootPane,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private GridPane buildGuiPane() {
		GridPane grid= new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(15, 25, 25, 25));
		Label martianMaker = new Label("Martian Maker");
		grid.add(martianMaker, 0, 0);
		
		//Creation Options for Martians
		grid.add(buildMartianSelector(), 0, 1);
		grid.add(buildIdSetter(), 0, 2);
		grid.add(buildMartianCharacteristics(), 0, 3);
		
		//Martian Process Buttons
		grid.add(buildMartianButtons(), 0, 5);
		
		//Martian Display
		txaMartianDisplay = new TextArea();
		txaMartianDisplay.setMaxSize(400, 100);
		grid.add(txaMartianDisplay, 0, 7);
		
		//Interactive Options for Martians
		grid.add(InteractiveOptionsBuilder(), 0, 6);
		
		return grid;
	}
	
	private Pane buildMartianSelector() {
		selectorPrompt = new Label("Choose a martian:");
		cmbMartians= new ComboBox<>();
		cmbMartians.setMaxWidth(100);
		cmbMartians.getItems().addAll("Select", "Red Martian", "Green Martian");
		cmbMartians.setValue("Select");
		
		HBox hbxMartianOps = new HBox();
		hbxMartianOps.setSpacing(10);
		hbxMartianOps.getChildren().addAll(selectorPrompt, cmbMartians);
		
		return hbxMartianOps;
	}
	
	private Pane buildIdSetter() {
		setId = new Label("Set ID:");
		setVol= new Label("Set Volume:");
		txfSetId = new TextField("0");
		txfSetId.setMaxWidth(50);
		txfSetVol = new TextField("0");
		txfSetVol.setMaxWidth(50);
		
		HBox hbxMartianId = new HBox();
		hbxMartianId.setSpacing(10);
		hbxMartianId.getChildren().addAll(setId, txfSetId, setVol, txfSetVol);
		
		return hbxMartianId;
	}
	
	private Pane buildMartianCharacteristics() {
		ckbHasEsp = new CheckBox("has ESP");
		ckbIsVegetarian = new CheckBox("is Vegetarian");
		rbGoToMars = new RadioButton("Teleport to Mars");
		
		HBox hbxMartianCharas = new HBox();
		hbxMartianCharas.setSpacing(10);
		hbxMartianCharas.getChildren().addAll(ckbHasEsp, ckbIsVegetarian, rbGoToMars);
		
		return hbxMartianCharas;
	}
	
	private Pane buildMartianButtons() {
		Button btnMartianProcessor = new Button("Process Martian");
		btnMartianProcessor.setOnAction(new ProcessMartianEventHandler());
		
		HBox hbxMartianButtons = new HBox();
		hbxMartianButtons.setSpacing(10);
		hbxMartianButtons.getChildren().addAll(btnMartianProcessor);
		
		return hbxMartianButtons;
	}
	
	//Process Martian button Event Handler
	private class ProcessMartianEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String strMartian= cmbMartians.getValue();
			int id= Integer.parseInt(txfSetId.getText());
			int vol= Integer.parseInt(txfSetVol.getText());
			boolean isVeg = false;
			boolean hasEsp = false;
			String martianDisplay = "";
			
			//Create & Display Martians
			if(strMartian.equals("Red Martian")) {
				if(ckbHasEsp.isSelected()) {
					hasEsp= true;
				}
				
				if(ckbIsVegetarian.isSelected()) {
					isVeg= true;
				}
				
				if(!(rbGoToMars.isSelected())) {
					RedMartian r = new RedMartian(id, hasEsp, isVeg);
					r.setVolume(vol);
					if(createdMartians.addMartian(r)== true){
						martianDisplay= r.toString();
						createdMartians.addMartian(r);
					}
				
					else if(createdMartians.addMartian(r)== false) { 
						martianDisplay= r.toString() + "\n";
						martianDisplay+= "A Martian with this ID already exists.";
					}
				}
				
				else if(rbGoToMars.isSelected()) {
					martianDisplay= "Only Green Martians can teleport.";
				}
			}
			
			if(strMartian.equals("Green Martian")) {
				if(ckbHasEsp.isSelected()) {
					hasEsp= true;
				}
				
				if(ckbIsVegetarian.isSelected()) {
					isVeg= true;
				}
				
				GreenMartian g = new GreenMartian(id, hasEsp, isVeg);
				g.setVolume(vol); 
				if(createdMartians.addMartian(g)== true){
					martianDisplay= g.toString() + "\n";
					createdMartians.addMartian(g);
					if(rbGoToMars.isSelected()) {
						martianDisplay+= String.format("Green Martian %d teleported to Mars", g.getId());
					}
				}
				
				else if(createdMartians.addMartian(g)== false) { 
					martianDisplay= g.toString() + "\n";
					martianDisplay+= "A Martian with this ID already exists.";
				}
			}
			
			//displaying martians
			txaMartianDisplay.setText(martianDisplay);
			
		}
	}
	
	//show all martian event handler 
	private class ShowAllMartiansEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String showAll= "All Martians:\n";
			for(int i= 0; i < createdMartians.getNumMartians(); i++) {
				showAll+= createdMartians.getMartianAt(i) + "\n";
			}
			
			txaMartianDisplay.setText(showAll);
		}
	}
	
	private Pane InteractiveOptionsBuilder() {
		removeMartianLabel = new Label("Remove Martian (Enter Id):");
		makeSpeakLabel = new Label("Make Martian speak (Enter Id):");
		groupTeleportLabel = new Label("Group teleport to:");
		txfRemoveMartian = new TextField();
		txfSpeak = new TextField();
		txfGroupTeleport = new TextField();
		txfRemoveMartian.setMaxWidth(50);
		txfSpeak.setMaxWidth(50);
		
		//Show all & remove all buttons
		Button btnShowAllMartians = new Button("Show All");
		btnShowAllMartians.setOnAction(new ShowAllMartiansEventHandler());
		Button btnRemoveAllMartians = new Button("Remove All");
		btnRemoveAllMartians.setOnAction(new RemoveAllEventHandler());
		Button btnSortMartians = new Button("Sort Martians");
		btnSortMartians.setOnAction(new SortMartiansEventHandler());
		
		HBox hbxAllMartianOps = new HBox();
		hbxAllMartianOps.setSpacing(10);
		hbxAllMartianOps.getChildren().addAll(btnShowAllMartians, btnRemoveAllMartians, btnSortMartians);
		
		//Remove, Speak, & Teleport buttons
		Button btnRemoveMartian = new Button("Remove");
		btnRemoveMartian.setOnAction(new RemoveMartianEventHandler());
		Button btnSpeak = new Button("Speak");
		btnSpeak.setOnAction(new SpeakMartianEventHandler());
		Button btnGroupTele = new Button("Go");
		btnGroupTele.setOnAction(new GroupTeleportEventHandler());
		
		//Remove options
		HBox hbxRemoveOps = new HBox();
		hbxRemoveOps.setSpacing(10);
		hbxRemoveOps.getChildren().addAll(removeMartianLabel, txfRemoveMartian, btnRemoveMartian);
		
		//Speak options
		HBox hbxSpeakOps = new HBox();
		hbxSpeakOps.setSpacing(10);
		hbxSpeakOps.getChildren().addAll(makeSpeakLabel, txfSpeak, btnSpeak);
		
		//Group teleport stuff
		HBox hbxGroupTele = new HBox();
		hbxGroupTele.setSpacing(10);
		hbxGroupTele.getChildren().addAll(groupTeleportLabel, txfGroupTeleport, btnGroupTele);
		
		//Vbox holds all options
		VBox vbxInteractiveOps = new VBox();
		vbxInteractiveOps.setSpacing(10);
		vbxInteractiveOps.getChildren().addAll(hbxRemoveOps, hbxSpeakOps, hbxGroupTele, hbxAllMartianOps);
		
		return vbxInteractiveOps;
	}
	
	private class RemoveMartianEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			int martianId = Integer.parseInt(txfRemoveMartian.getText());
			String msg = "";
			
			if(createdMartians.removeMartian(martianId) == true) {
				createdMartians.removeMartian(martianId);
				msg = String.format("Martian ID # %d has been removed.", martianId);
			}
			
			else if(createdMartians.removeMartian(martianId) == false) {
				msg = String.format("Martian ID # %d does not exist.", martianId);
			}
			
			txaMartianDisplay.setText(msg);
		}
	}
	
	private class SpeakMartianEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			int martianId = Integer.parseInt(txfSpeak.getText());
			String msg = "";
			
			if(createdMartians.getMartianWithId(martianId) instanceof RedMartian) {
				msg= "Red Martian - " + createdMartians.getMartianWithId(martianId).speak();
			}
			
			if(createdMartians.getMartianWithId(martianId) instanceof GreenMartian) {
				msg= "Green Martian - " + createdMartians.getMartianWithId(martianId).speak();
			}
			
			txaMartianDisplay.setText(msg);
		}
	}
	
	private class RemoveAllEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			createdMartians.obliterateMartians();
			txaMartianDisplay.setText("All Martians have been removed.");
		}
	}
	
	private class SortMartiansEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String showAll= "Sorted Martians:\n";
			for(int i= 0; i < createdMartians.sortedMartians().size(); i++) {
				showAll+= createdMartians.sortedMartians().get(i) + "\n";
			}
			
			txaMartianDisplay.setText(showAll);
		}
		
	}
	
	private class GroupTeleportEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String goTo = txfGroupTeleport.getText();
			String teleport = createdMartians.groupTeleport(goTo);
			txaMartianDisplay.setText(teleport);
		}
	}
	
	//End of Martian Grid Pane
	
	//Martian File Tab
	private GridPane buildMartianFilePane() {
		GridPane grid= new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(15, 25, 25, 25));
		grid.add(new Label("Martian From A File"), 0, 0);
		
		//User Input stuff
		grid.add(buildUserTxfInput(), 0, 1);
		
		//Martian Display
		txaMartianFileDisplay = new TextArea();
		txaMartianFileDisplay.setMaxSize(400, 100);
		grid.add(txaMartianFileDisplay, 0, 3);
		
		return grid;
	}
	
	private Pane buildUserTxfInput() {
		userFileLable = new Label("Enter Your Martian File:");
		userWriterFileLable = new Label("Write Martians to:");
		txfUserWriterFile = new TextField("ex.)src\\application\\writeMartians.txt");
		txfUserFile = new TextField("ex.) src\\application\\martians.txt");
		
		//Read Martian File Stuff
		Button btnUserFile = new Button("Process Martians");
		btnUserFile.setOnAction(new UserFileEventHandler());
		HBox hbxUserFile = new HBox();
		hbxUserFile.setSpacing(10);
		hbxUserFile.getChildren().addAll(userFileLable, txfUserFile, btnUserFile);
		
		//Write Martian File Stuff
		Button btnUserWriterFile = new Button("Write File");
		btnUserWriterFile.setOnAction(new UserWriterEventHandler());
		HBox hbxUserWriterFile = new HBox();
		hbxUserWriterFile.setSpacing(10);
		hbxUserWriterFile.getChildren().addAll(userWriterFileLable, txfUserWriterFile, btnUserWriterFile);
		
		VBox vbxUserFiles = new VBox();
		vbxUserFiles.setSpacing(10);
		vbxUserFiles.getChildren().addAll(hbxUserFile, hbxUserWriterFile);
		
		return vbxUserFiles;
	}
	
	private class UserFileEventHandler implements EventHandler<ActionEvent>{		
		@Override
		public void handle(ActionEvent event) {
			File userFile = new File(txfUserFile.getText());
			
			try {
				Scanner input = new Scanner(userFile);
				while(input.hasNext()) {
					String line = input.nextLine();
					String[] tokens = line.split(" ");
					String martianType = tokens[0];
					int id= Integer.parseInt(tokens[1]);
					
					//Red Martians
					if(martianType.equals("R")) {
						if(tokens.length == 2) {
							RedMartian red = new RedMartian(id);
							createdMartians.addMartian(red);
						}
						
						if(tokens.length == 3) {
							int vol= Integer.parseInt(tokens[2]);
							RedMartian red2 = new RedMartian(id);
							red2.setVolume(vol);
							createdMartians.addMartian(red2);
						}
						
						if(tokens.length == 4) {
							int vol = 0;
							if(tokens[2].equals("t") && tokens[3].equals("f")) {
								RedMartian red2 = new RedMartian(id, vol, true, false);
								createdMartians.addMartian(red2);
							}
							
							else if(tokens[2].equals("t") && tokens[3].equals("t")) {
								RedMartian red2 = new RedMartian(id, vol, true, true);
								createdMartians.addMartian(red2);
							}
							
							else if(tokens[2].equals("f") && tokens[3].equals("f")) {
								RedMartian red2 = new RedMartian(id, vol, false, false);
								createdMartians.addMartian(red2);
							}
							
							else if(tokens[2].equals("f") && tokens[3].equals("t")) {
								RedMartian red2 = new RedMartian(id, vol, false, true);
								createdMartians.addMartian(red2);
							}
						}
						
						if(tokens.length == 5) {
							int vol= Integer.parseInt(tokens[2]);
							if(tokens[3].equals("t") && tokens[4].equals("f")) {
								RedMartian red3 = new RedMartian(id, vol, true, false);
								createdMartians.addMartian(red3);
							}
							
							else if(tokens[3].equals("t") && tokens[4].equals("t")) {
								RedMartian red3 = new RedMartian(id, vol, true, true);
								createdMartians.addMartian(red3);
							}
							
							else if(tokens[3].equals("f") && tokens[4].equals("f")) {
								RedMartian red3 = new RedMartian(id, vol, false, false);
								createdMartians.addMartian(red3);
							}
							
							else if(tokens[3].equals("f") && tokens[4].equals("t")) {
								RedMartian red3 = new RedMartian(id, vol, false, true);
								createdMartians.addMartian(red3);
							}
						}
					}
					
					//Green Martians
					if(martianType.equals("G")) {
						if(tokens.length == 2) {
							GreenMartian green = new GreenMartian(id);
							createdMartians.addMartian(green);
						}
						
						if(tokens.length == 3) {
							int vol= Integer.parseInt(tokens[2]);
							GreenMartian g2 = new GreenMartian(id);
							g2.setVolume(vol);
							createdMartians.addMartian(g2);
						}
						
						if(tokens.length == 4) {
							int vol = 0;
							if(tokens[2].equals("t") && tokens[3].equals("f")) {
								GreenMartian g2 = new GreenMartian(id, vol, true, false);
								createdMartians.addMartian(g2);
							}
							
							else if(tokens[2].equals("t") && tokens[3].equals("t")) {
								GreenMartian g2 = new GreenMartian(id, vol, true, true);
								createdMartians.addMartian(g2);
							}
							
							else if(tokens[2].equals("f") && tokens[3].equals("f")) {
								GreenMartian g2 = new GreenMartian(id, vol, false, false);
								createdMartians.addMartian(g2);
							}
							
							else if(tokens[2].equals("f") && tokens[3].equals("t")) {
								GreenMartian g2 = new GreenMartian(id, vol, false, true);
								createdMartians.addMartian(g2);
							}
						}
						
						if(tokens.length == 5) {
							int vol= Integer.parseInt(tokens[2]);
							if(tokens[3].equals("t") && tokens[4].equals("f")) {
								GreenMartian g3 = new GreenMartian(id, vol, true, false);
								createdMartians.addMartian(g3);
							}
							
							else if(tokens[3].equals("t") && tokens[4].equals("t")) {
								GreenMartian g3 = new GreenMartian(id, vol, true, true);
								createdMartians.addMartian(g3);
							}
							
							else if(tokens[3].equals("f") && tokens[4].equals("f")) {
								GreenMartian g3 = new GreenMartian(id, vol, false, false);
								createdMartians.addMartian(g3);
							}
							
							else if(tokens[3].equals("f") && tokens[4].equals("t")) {
								GreenMartian g3 = new GreenMartian(id, vol, false, true);
								createdMartians.addMartian(g3);
							}
						}
					}
				}
			}
			catch(Exception e) {
				System.out.print(e);
			}
			
			String showAll= "All Martians:\n";
			for(int i= 0; i < createdMartians.getNumMartians(); i++) {
				showAll+= createdMartians.getMartianAt(i) + "\n";
			}
			
			txaMartianFileDisplay.setText(showAll);
		}
	}
	
	private class UserWriterEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			String writerFile = txfUserWriterFile.getText();
			File outFile = new File(writerFile);
			
			try {
				PrintWriter writer = new PrintWriter(outFile);
				for(int i= 0; i < createdMartians.getNumMartians(); i++) {
					writer.print(createdMartians.getMartianAt(i) + "\n");
				}
				writer.close();
			}
			catch(IOException ioe) {
				System.out.println("Couldn't write file.");
			}
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
