
public class SolarPanels 
{
    
    private Panel[][] panels;
    private String[][] streetMap;
    private ParkingLot[] lots;
    private int length;
    private int width;
    private int totalLots;


    public SolarPanels() 
    {
        panels = null;
        streetMap = null;
        lots = null;
        StdRandom.setSeed(2023);
    }


    public void setupStreetMap(String streetMapFile) 
    {
        StdIn.setFile(streetMapFile);
        length = StdIn.readInt();
        width = StdIn.readInt();
        streetMap = new String [length][width];
        for (int row = 0; row < length; row++)
        {
            for (int col = 0; col < width; col++)
            {
                streetMap[row][col] = StdIn.readString();
            }
        }
    }


    public void setupParkingLots(String parkingLotFile) 
    {
        StdIn.setFile(parkingLotFile);
        totalLots = StdIn.readInt();
        lots = new ParkingLot[totalLots];
        for (int currLotNum = 0; currLotNum < totalLots; currLotNum++)
        {
            String name = StdIn.readString();
            int maxPanels = StdIn.readInt();
            double budget = StdIn.readDouble();
            int energyCap = StdIn.readInt();
            double panelEff = StdIn.readDouble();
            ParkingLot currParkingLot = new ParkingLot(name, maxPanels, budget, energyCap, panelEff);
            lots[currLotNum] = currParkingLot;
        }

    }

 
    public void insertPanels(double costPerPanel) 
    {
        panels = new Panel[length][width]; //panels is an array of Panel objects
        for (int currLotNum = 0; currLotNum < totalLots; currLotNum++)
        {
            int numPanelsInstalled = 0;
            double budgetRemaining = lots[currLotNum].getBudget();
            String currLotName = lots[currLotNum].getLotName();
            for (int row = 0; row < length; row++)
            {
                for (int col = 0; col < width; col++)
                {
                    if (currLotName.equals(streetMap[row][col]) && budgetRemaining >= costPerPanel && numPanelsInstalled < lots[currLotNum].getMaxPanels())
                    {
                        double ratedEffic = lots[currLotNum].getPanelEfficiency();
                        int maxOutput = lots[currLotNum].getEnergyCapacity();
                        boolean probWorks;
                        if (StdRandom.uniform() < 0.95)
                        {
                            probWorks = true;
                        }
                        else
                        {
                            probWorks = false;
                        } 
                        panels[row][col] = new Panel(ratedEffic, maxOutput, probWorks);
                        numPanelsInstalled++;
                        budgetRemaining -= costPerPanel;
                    }
                }
            }
        }
        
    }

 
    public void updateActualEfficiency(int temperature, double coefficient) 
    {
        double efficChange = coefficient * (temperature - 77);
        for (int row = 0; row < length; row++)
        {
            for(int col = 0; col < width; col++)
            {
                if(panels[row][col] != null)
                {
                    double currentEffic = panels[row][col].getActualEfficiency();
                    panels[row][col].setActualEfficiency(currentEffic - efficChange);
                }
                
            }
        }
    }


    public void updateElectricityGenerated() 
    {
        for (int row = 0; row < length; row++)
        {
            for(int col = 0; col < width; col++)
            {
                if (panels[row][col] != null && panels[row][col].isWorking())
                {
                    double actualEfficiency = panels[row][col].getActualEfficiency(); 
                    double dailyOutput = (actualEfficiency/100)*1500*4;
                    panels[row][col].setElectricityGenerated((int)dailyOutput);
                }
            }
        }
    }


    public int countWorkingPanels(String parkingLot) 
    {
        int count = 0; 
        for (int row = 0; row < length; row++){
            for (int col = 0; col < width; col++){
                if (streetMap[row][col].equals(parkingLot) && panels[row][col] != null && panels[row][col].isWorking()){
                    count++;
                }
            }
        }
        return count;
    }

 
    public int updateWorkingPanels() {
       int count = 0;
       for (int row = 0; row < length; row++){
            for (int col = 0; col < width; col++){
                if (panels[row][col] != null && panels[row][col].isWorking()){
                    count++;
                }
                else if (panels[row][col] != null && !(panels[row][col].isWorking())){
                    panels[row][col].setIsWorking(true);
                    count++;
                }
            }
       }
       return count;
    }


    public double calculateSavings() 
    {
        double totalEnergy = 0;
        for (int row = 0; row < length; row++){
            for (int col = 0; col < width; col++){
                if (panels[row][col] != null){
                    totalEnergy += panels[row][col].getElectricityGenerated();
                }
            }
        }
        totalEnergy *= 0.001;
        totalEnergy *= 365; 
        return totalEnergy / 4270000.0 * 60000000;
    }

 
    public Panel[][] getPanels() {
        // DO NOT TOUCH THIS METHOD
        return this.panels;
    }

    public void setPanels(Panel[][] panels) {
        // DO NOT TOUCH THIS METHOD
        this.panels = panels;
    }

    public String[][] getStreetMap() {
        // DO NOT TOUCH THIS METHOD
        return this.streetMap;
    }

    public void setStreetMap(String[][] streetMap) {
        // DO NOT TOUCH THIS METHOD
        this.streetMap = streetMap;
    }

    public ParkingLot[] getLots() {
        // DO NOT TOUCH THIS METHOD
        return this.lots;
    }

    public void setLots(ParkingLot[] lots) {
        // DO NOT TOUCH THIS METHOD
        this.lots = lots;
    }
}

