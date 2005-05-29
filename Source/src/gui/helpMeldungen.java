package gui;


import javax.swing.*;

public class helpMeldungen {

  public static void showInformationMessage(String message)
  {
    /**
     * In dieser Methode wird ein einfaches Dialogfenster geoeffnet und ein
     * Informationsicon angezeigt. Es wird nur ein OK-Button angezeigt, der bei
     * Betaetigung das Dialogfenster wieder schliesst.
     */
    JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showErrorMessage(String message)
  {
    /**
     * In dieser Methode wird ein einfaches Dialogfenster geoeffnet und ein
     * Fehlericon angezeigt. Es wird nur ein OK-Button angezeigt, der bei
     * Betaetigung das Dialogfenster wieder schliesst.
     */
    JOptionPane.showMessageDialog(null, message, "Fehler", JOptionPane.ERROR_MESSAGE);
  }

  public static void showWarningMessage(String message)
  {
    /**
     * In dieser Methode wird ein einfaches Dialogfenster geoeffnet und ein
     * Warnungsicon angezeigt. Es wird nur ein OK-Button angezeigt, der bei
     * Betaetigung das Dialogfenster wieder schliesst.
     */
    JOptionPane.showMessageDialog(null, message, "Achtung", JOptionPane.WARNING_MESSAGE);
  }

  public static boolean showOptionDialog1(String message, String title, String[] buttonNames)
  {
    /**
     * In dieser Methode wird ein Dialogfenster geoeffnet und zwei Buttons als
     * Aktionsauswahl angezeigt. Mit dem Parameter buttonsNames koennen Namen fuer
     * diese beiden Buttons definiert werden.
     * True wird zurueckgegeben, wenn der 1. Button in buttonNames gedrueckt wurde.
     * (Soll dem Schema OK - CANCEL oder YES - NO entsprechen)
     */
    JOptionPane dialog = new JOptionPane();
    int option = dialog.showOptionDialog(null, message, title,
           JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
           buttonNames, buttonNames[0]);
      if(dialog.OK_OPTION==option)
        return true;
      return false;
  }

  public static int showOptionDialog2(String message, String title, String[] buttonNames)
  {
    /**
    * In dieser Methode wird ein Dialogfenster geoeffnet und drei Buttons als
    * Aktionsauswahl angezeigt. Mit dem Parameter buttonsNames koennen Namen fuer
    * diese drei Buttons definiert werden.
    * 1 wird zurueckgegeben, wenn der 1. Button in buttonNames gedrueckt wurde,
    * -1 wird zurueckgegebenm wenn der 2. Button aus buttonNames betaetigt wurde.
    * (Soll dem Schema YES - NO - CANCEL entsprechen)
    */
    JOptionPane dialog = new JOptionPane();
    int option = dialog.showOptionDialog(null, message, title,
           JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
           buttonNames, buttonNames[0]);
      if(dialog.OK_OPTION==option)
        return 1;
      if(dialog.CANCEL_OPTION==option)
        return 0;
      return -1;
  }

}