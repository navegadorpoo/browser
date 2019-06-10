package gui.components.modal;

public class HistoryModal extends AbstractModal {
    public HistoryModal() {
        super(new String[] {"ID", "Nome", "Endereço", "Data de Acesso", "Remover"});
        table.setName("history");
    }
    
    public void addRow(int id, String name, String url, String datetime) {
        model.addRow(new Object[] {id, name, url, datetime, "Lixeira"});
    }
}
