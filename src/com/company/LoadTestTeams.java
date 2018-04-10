package com.company;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadTestTeams {
    private static final String FILENAME = "testdata.xls";
    private ArrayList<Team> loadedTeams = new ArrayList<>();

    public ArrayList<Team> loadSampleTeams(){
        try{
            FileInputStream excelFile = new FileInputStream(new File(FILENAME));
            Workbook workbook = new HSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheet("Teams");
            Iterator<Row> iterator = datatypeSheet.iterator();
            while(iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                //  An array to store each value from the sheet for the team
                Iterator<Cell> cellIterator = currentRow.iterator();
                String teamName = "None";
                boolean isClub = false;
                int gamesWon = 0;
                int gamesDrawn = 0;
                int gamesLost = 0;
                int goalsScored = 0;
                int goalsConceded = 0;

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    switch (currentCell.getColumnIndex()) {
                        case 0:
                            teamName = currentCell.getStringCellValue();
                            break;
                        case 1:
                            isClub = currentCell.getBooleanCellValue();
                            break;
                        case 2:
                            gamesWon = (int)currentCell.getNumericCellValue();
                            break;
                        case 3:
                            gamesDrawn = (int)currentCell.getNumericCellValue();
                            break;
                        case 4:
                            gamesLost = (int)currentCell.getNumericCellValue();
                            break;
                        case 5:
                            goalsScored = (int)currentCell.getNumericCellValue();
                            break;
                        case 6:
                            goalsConceded = (int)currentCell.getNumericCellValue();
                        default:
                            break;
                    }
                }
                Team newTeam = new Team(teamName, isClub, gamesWon, gamesDrawn, gamesLost, goalsScored, goalsConceded);
                loadedTeams.add(newTeam);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return loadedTeams;
    }

    public ArrayList<Team> getLeagueTeams(){
        return loadedTeams;
    }
}