package gui.components.menu.button.imagebutton;

import gui.components.interaction.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import lib.browser.Bookmark;

import lib.browser.Browser;
import lib.browser.Location;
import lib.database.repositories.BookmarkRepository;

public class BookmarkButton extends ImageButton {
    
    public BookmarkButton() {
        super("star");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Location location = Browser.getInstance().getWindow().getPagination().getLocation();
                
                if (location == null) {
                    Dialog.showMessage(
                        "info",
                        "Atenção",
                        "Necessário acessar uma página primeiro."
                    );
                    return;
                }
                        
                String name = Dialog.showInput(
                    "Com qual nome deseja salvar?"
                );
                
                if (name != null) {
                    try {
                        BookmarkRepository.insert(
                            new Bookmark(
                                name,
                                Browser.getInstance().getWindow().getPagination().getLocation()
                            )
                        );
                        Dialog.showMessage(
                            "success",
                            "Sucesso",
                            "Adicionado aos favoritos com sucesso."
                        );
                    } catch (SQLException e) {
                        Dialog.showMessage(
                            "error",
                            "Atenção",
                            "Erro ao inserir favorito"
                        );
                    }
                }
            }
        });
    }
}
