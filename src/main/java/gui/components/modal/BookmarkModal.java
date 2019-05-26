package gui.components.modal;

public class BookmarkModal extends AbstractModal {
    public BookmarkModal() {
        super(new String[] {"Nome", "Endereço", "Remover"});
    }

    public void addRow(String name, String url) {
        model.addRow(new Object[] {name, url, "Lixeira"});
    }
}
