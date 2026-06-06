/**
 BATTLESHIP
 • set grid[3][5] - odd value, has a center
 • deploy ships - minimum of 1 ship not greater than the grid, (grid-3) , ship move adjacent,
 • set coordinate - locate[0][0]
 • legend - ship destroyed indicator is X, missed indicator is !,
 • no. of ammo is equal to total of grid
 • put hash or bullet in the center of the grid
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {

    static int deployShips(int totalGrid) {
        int minShip = 1;
        int maxShip = totalGrid - 3;
        Random rand = new Random();
        return rand.nextInt(maxShip - minShip + 1) + minShip;
    }

    static void moveShips(String[][] gridNumbers, int firstGridVal, int secondGridVal) {
        Random rand = new Random();
        int[] directions = {-1, 0, 1};
        int middleRow = firstGridVal / 2;
        int middleCol = secondGridVal / 2;

        // Temporary grid to prevent overlapping moves
        String[][] newGrid = new String[firstGridVal][secondGridVal];
        for (int i = 0; i < firstGridVal; i++) {
            Arrays.fill(newGrid[i], "0");
        }

        for (int row = 0; row < firstGridVal; row++) {
            for (int col = 0; col < secondGridVal; col++) {
                if (!gridNumbers[row][col].equals("0")) {
                    String value = gridNumbers[row][col];
                    int newRow = row, newCol = col;
                    boolean moved = false;

                    for (int attempt = 0; attempt < 10; attempt++) { // Limit attempts to prevent infinite loop
                        int dRow = directions[rand.nextInt(3)];
                        int dCol = directions[rand.nextInt(3)];

                        if (Math.abs(dRow) + Math.abs(dCol) == 1) {
                            newRow = row + dRow;
                            newCol = col + dCol;
                            if (newRow >= 0 && newRow < firstGridVal && newCol >= 0 && newCol < secondGridVal && newGrid[newRow][newCol].equals("0") && !(newRow == middleRow && newCol == middleCol)) {
                                moved = true;
                                break;
                            }
                        }
                    }

                    if (moved) {
                        newGrid[newRow][newCol] = value;
                    } else {
                        newGrid[row][col] = value; // Stay in place if no move possible
                    }
                }
            }
        }

        // Copy newGrid back to gridNumbers
        for (int i = 0; i < firstGridVal; i++) {
            for (int j = 0; j < secondGridVal; j++) {
                gridNumbers[i][j] = newGrid[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int firstGridVal, secondGridVal;

        // Grid size input with validation
        while (true) {
            System.out.print("Enter 1st grid value (odd number): ");
            firstGridVal = sc.nextInt();
            if (firstGridVal % 2 != 0) break;
            System.out.println("Invalid input! Please enter an odd number.");
        }

        while (true) {
            System.out.print("Enter 2nd grid value (odd number): ");
            secondGridVal = sc.nextInt();
            if (secondGridVal % 2 != 0) break;
            System.out.println("Invalid input! Please enter an odd number.");
        }

        String[][] gridBox = new String[firstGridVal][secondGridVal];
        for (int i = 0; i < firstGridVal; i++) {
            Arrays.fill(gridBox[i], "0");
        }

        int totalGrid = firstGridVal * secondGridVal;
        int totalShips = deployShips(totalGrid);
        int placedShips = 0;

        int middleRow = firstGridVal / 2;
        int middleCol = secondGridVal / 2;
        int ammo = totalGrid; // Ammo is equal to the grid size

        // Place ships randomly
        while (placedShips < totalShips) {
            int randRow = rand.nextInt(firstGridVal);
            int randCol = rand.nextInt(secondGridVal);
            if (gridBox[randRow][randCol].equals("0") && !(randRow == middleRow && randCol == middleCol)) {
                gridBox[randRow][randCol] = String.valueOf(placedShips + 1);
                placedShips++;
            }
        }

        System.out.println("Legend:");
        System.out.println("# - Center of the grid");
        System.out.println("X - Ship destroyed");
        System.out.println("! - Missed shot");
        System.out.println("Numbers - Ships");

        // Game loop
        while (ammo > 0 && totalShips != 0) {
            System.out.println("Game Grid:");
            for (int i = 0; i < firstGridVal; i++) {
                System.out.println("+-----".repeat(secondGridVal) + "+");
                for (int j = 0; j < secondGridVal; j++) {
                    if (i == middleRow && j == middleCol) {
                        System.out.print("|  #  ");
                    } else if (gridBox[i][j].equals("X")) {
                        System.out.print("|  X  ");
                    } else if (gridBox[i][j].equals("!")) {
                        System.out.print("|  !  ");
                    } else if (!gridBox[i][j].equals("0")) {
                        System.out.printf("| %2s  ", gridBox[i][j]);
                    } else {
                        System.out.print("|     ");
                    }
                }
                System.out.println("|");
            }
            System.out.println("+-----".repeat(secondGridVal) + "+");
            System.out.println("Total ships deployed: " + totalShips);
            System.out.println("Ammo left: " + ammo);
            System.out.print("ENTER THE COORDINATE (row,col): ");
            String coordinates = sc.next();

            try {
                // Validate input format "row,col"
                if (!coordinates.matches("^\\d+,\\d+$")) {
                    System.out.println("Invalid format! Please enter coordinates in the format row,col.");
                    continue;
                }

                String[] convert = coordinates.split(",");
                int coordinateRow = Integer.parseInt(convert[0].trim());
                int coordinateCol = Integer.parseInt(convert[1].trim());

                // Check if the coordinates are within bounds
                if (coordinateRow < 0 || coordinateRow >= firstGridVal || coordinateCol < 0 || coordinateCol >= secondGridVal) {
                    System.out.println("Invalid coordinates! Out of bounds. Try again.");
                    continue;
                }

                if(coordinateRow == middleRow && coordinateCol == middleCol)
                {
                    System.out.println("Invalid coordinates.");
                    System.out.println("You cannot target center.");
                    continue;
                }

                for(int i = 0; i < firstGridVal; i++)
                {
                    for(int j = 0; j < secondGridVal; j++)
                    {
                        if(gridBox[i][j].equals("X") || gridBox[i][j].equals("!"))
                        {
                            gridBox[i][j] = "0";


                        }
                    }
                }

                // Move ships before checking for hits
                moveShips(gridBox, firstGridVal, secondGridVal);

                // Check if there is a ship at the entered coordinates
                if (!gridBox[coordinateRow][coordinateCol].equals("0")) {
                    int shipNumber = Integer.parseInt(gridBox[coordinateRow][coordinateCol]);
                    System.out.println("Bullseye!! You hit ship #" + shipNumber + "!");

                    // Remove all occurrences of this ship number from the grid
                    for (int i = 0; i < firstGridVal; i++) {
                        for (int j = 0; j < secondGridVal; j++) {
                            if (gridBox[i][j].equals(String.valueOf(shipNumber))) {
                                gridBox[i][j] = "X"; // Mark as destroyed
                            }
                        }
                    }
                    totalShips--; // Reduce the ship count
                    ammo--;
                } else {
                    System.out.println("Missed.");
                    gridBox[coordinateRow][coordinateCol] = "!"; // Mark as missed
                    ammo--;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter coordinates in the format row,col.");
            }
        }

        if (ammo == 0 && totalShips != 0) {
            System.out.println("Game Over! You ran out of ammo. Better luck next time!");
        }

        if (totalShips == 0 && ammo != 0) {
            System.out.println("Congratulations! You destroyed all the ships and won the game!");
        }
        sc.close();
    }
}

