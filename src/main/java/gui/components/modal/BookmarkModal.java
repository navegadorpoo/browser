package gui.components.modal;

public class BookmarkModal extends AbstractModal {
    public BookmarkModal() {
        super(new String[] {"ID", "Nome", "Endereço", "Remover"});
        table.setName("bookmark");
    }

    public void addRow(int id, String name, String url) {
        model.addRow(new Object[] {id, name, url, "Lixeira"});
    }
}
