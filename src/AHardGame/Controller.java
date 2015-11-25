package AHardGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;


public class Controller
{
    @FXML
    private TextField NameField;
    @FXML
    private Button NameButton;
    @FXML
    private Text NameText;
    @FXML
    private Text GivenName;
    @FXML
    private Text ReadyText;
    @FXML
    private RadioButton Rock;
    @FXML
    private RadioButton Paper;
    @FXML
    private RadioButton Scissor;
    @FXML
    private Label ComputerScore;
    @FXML
    private Label PlayerScore;


    private String playerName;
    private Alert InvalidName ;
    private Alert InvalidSelection;
    private Alert tie = new Alert(Alert.AlertType.INFORMATION);
    private Alert lose = new Alert(Alert.AlertType.WARNING);
    private Alert win = new Alert(Alert.AlertType.INFORMATION);
    private int chanceOfWinning = 5;
    private int determineWinOrLose;
    private int temp;

    public void nameSubmission(ActionEvent event)
    {
        if(NameField.getText().isEmpty())
        {
            InvalidName = new Alert(Alert.AlertType.ERROR);
            InvalidName.setTitle("Invalid Name");
            InvalidName.setContentText("Software did not detect any text!!!");
            InvalidName.setHeaderText("Critical Error");
            InvalidName.showAndWait();

        }
        else
        {
            playerName = NameField.getText();
            NameText.setVisible(false);
            NameButton.setVisible(false);
            NameField.setVisible(false);
            GivenName.setText(playerName);
            GivenName.setTextAlignment(TextAlignment.CENTER);
            GivenName.setUnderline(true);
            ReadyText.setVisible(true);
        }
    }

    public void userChoiceSubmission(ActionEvent e)
    {
        if((Rock.isSelected())&&(Paper.isSelected())&&(Scissor.isSelected()))
        {
            InvalidSelection = new Alert(Alert.AlertType.ERROR);
            InvalidSelection.setContentText("You can only select one.");
            InvalidSelection.showAndWait();
            Rock.setSelected(false);
            Paper.setSelected(false);
            Scissor.setSelected(false);
        }
        else
        {
            if((Rock.isSelected()&&Paper.isSelected())
                    ||(Rock.isSelected()&&Scissor.isSelected())
                    ||(Scissor.isSelected()&&Paper.isSelected()))
            {
                InvalidSelection = new Alert(Alert.AlertType.ERROR);
                InvalidSelection.setContentText("You can only select one. Not 2.");
                InvalidSelection.showAndWait();
                Rock.setSelected(false);
                Paper.setSelected(false);
                Scissor.setSelected(false);
            }

            GoodForCompetition(e);


        }

    }

    public void GoodForCompetition(ActionEvent e)
    {
        determineWinOrLose = (int)(Math.random()*10)+1;
        temp = (int)(Math.random()*3)+1;
        Integer a = 5;

        if(determineWinOrLose <= chanceOfWinning)
        {
            if(Rock.isSelected())
            {
                if(temp == 1)
                {
                    tie.setContentText("A tie.");
                    tie.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);


                }
                if(temp == 3)
                {
                    win.setContentText("Yayy, You win.");
                    win.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                    PlayerScore.setText(a.parseInt(PlayerScore.getText())+1+"");

                }
                if(temp == 2)
                {
                    lose.setContentText("You Lose Hahaha.");
                    lose.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                    ComputerScore.setText(a.parseInt(ComputerScore.getText())+1+"");
                }
            }
            if(Paper.isSelected())
            {
                if(temp == 1)
                {
                    win.setContentText("Yayy, You win.");
                    win.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                    PlayerScore.setText(a.parseInt(PlayerScore.getText())+1+"");
                }
                if(temp == 2)
                {
                    tie.setContentText("A tie.");
                    tie.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                }
                if(temp == 3)
                {
                    lose.setContentText("You Lose Hahaha.");
                    lose.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                    ComputerScore.setText(a.parseInt(ComputerScore.getText())+1+"");
                }
            }
            if(Scissor.isSelected())
            {
                if(temp == 1)
                {
                    lose.setContentText("You Lose Hahaha.");
                    lose.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                    ComputerScore.setText(a.parseInt(ComputerScore.getText())+1+"");
                }
                if(temp == 2)
                {
                    win.setContentText("Yayy, You win.");
                    win.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                    PlayerScore.setText(a.parseInt(PlayerScore.getText())+1+"");
                }
                if(temp == 3)
                {
                    tie.setContentText("A tie.");
                    tie.showAndWait();
                    Rock.setSelected(false);
                    Paper.setSelected(false);
                    Scissor.setSelected(false);
                }
            }
        }
        else
        {
            lose.setContentText("You Lose Hahaha !!!");
            lose.showAndWait();
            Rock.setSelected(false);
            Paper.setSelected(false);
            Scissor.setSelected(false);
            ComputerScore.setText(a.parseInt(ComputerScore.getText())+1+"");
        }
    }


}
