import javax.swing.*;

public class AView {
	private static AView totalMView = null;
    private static AView totalUView = null;
    private static AView totalGView = null;
    
    private static JFrame[] AWindows = new JFrame[3];
    private static JLabel[] titleFields = new JLabel[3];
    private static JLabel[] dataFields = new JLabel[3];
    private static JPanel[] APanels = new JPanel[3];
   

    private AView(String title, int data, int i, boolean display) {
        AWindows[i] = new JFrame();

        APanels[i] = new JPanel();
        titleFields[i] = new JLabel(title, JLabel.CENTER);
        APanels[i].add(titleFields[i]);
        dataFields[i] = new JLabel();
        dataFields[i].setText(new Integer(data).toString());
        APanels[i].add(dataFields[i]);

        AWindows[i].add(APanels[i]);
        AWindows[i].setVisible(display);
        AWindows[i].setSize(200, 100);
    }

    public static void getTotalUsersViewInstance(String title, int data, boolean display){
        if(totalUView == null){
            totalUView = new AView(title, data, 0, display);
        }
        else{
            totalUView.dataFields[0].setText(new Integer(data).toString());
            if(AWindows[0].isVisible() || display == true) {
                AWindows[0].setVisible(true);
            }
            else{
                AWindows[0].setVisible(false);
            }
        }
    }

    public static void getTotalGroupsViewInstance(String title, int data, boolean display){
        if(totalGView == null){
            totalGView = new AView(title, data, 1, display);
        }
        else{
            totalGView.dataFields[1].setText(new Integer(data).toString());
            if(AWindows[1].isVisible() || display == true) {
                AWindows[1].setVisible(true);
            }
            else{
                AWindows[1].setVisible(false);
            }
        }
    }

    public static void getTotalMessagesViewInstance(String title, int data, boolean display){
        if(totalMView == null){
            totalMView = new AView(title, data, 2, display);
        }
        else{
            totalMView.dataFields[2].setText(new Integer(data).toString());
            if(AWindows[2].isVisible() || display == true) {
                AWindows[2].setVisible(true);
            }
            else{
               AWindows[2].setVisible(false);
            }
        }
    }

}