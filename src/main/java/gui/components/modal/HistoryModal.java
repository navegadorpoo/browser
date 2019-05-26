package gui.components.modal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JButton;

public class HistoryModal extends AbstractModal {
    public HistoryModal() {
        super(new String[] {"Nome", "Endereço", "Data de Acesso", "Remover"});
    }
    
    public void addRow(String name, String url) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss", new Locale("pt", "BR"));
        model.addRow(new Object[] {name, url, df.format(calendar.getTime()), "Lixeira"});
    }
}
