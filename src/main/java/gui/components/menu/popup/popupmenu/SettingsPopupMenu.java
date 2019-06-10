package gui.components.menu.popup.popupmenu;

import gui.components.menu.popup.popupitem.PopupItem;
import gui.components.modal.BookmarkModal;
import gui.components.modal.HistoryModal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lib.browser.Bookmark;
import lib.browser.BookmarkList;
import lib.browser.Browser;
import lib.browser.History;
import lib.browser.HistoryList;
import lib.browser.Location;

public class SettingsPopupMenu extends PopupMenu {
    PopupItem bookmarkPopupItem = new PopupItem("Favoritos");
    PopupItem historyPopupItem  = new PopupItem("Histórico");

    public SettingsPopupMenu() {
        add(bookmarkPopupItem);
        add(historyPopupItem);
        setEvents();
    }
    
    public final void setEvents() {
        bookmarkPopupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BookmarkModal bookmarkModal = new BookmarkModal();
                BookmarkList bookmarkList = Browser.getInstance().getWindow().getBookmarkList();
                for (Object object : bookmarkList) {
                    Bookmark b = (Bookmark) object;
                    bookmarkModal.addRow(b.getId(), b.getName(), b.getLocation().getUrl());
                }
                bookmarkModal.show();
            }
        });
        
        historyPopupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HistoryModal historyModal = new HistoryModal();
                HistoryList history = Browser.getInstance().getWindow().getHistory();
                for (Object object : history) {
                    History h = (History) object;
                    Location l = h.getLocation();
                    historyModal.addRow(h.getId(), l.getTitle(), l.getUrl(), l.getDateToShow());
                }
                historyModal.show();
            }
        });
    }
}