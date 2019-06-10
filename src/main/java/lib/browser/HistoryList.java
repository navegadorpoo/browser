package lib.browser;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import lib.database.repositories.HistoryRepository;

public class HistoryList implements Iterable {
    private LinkedList<History> historyList = new LinkedList<>();
    
    public void add(History history) {
        historyList.add(history);
    }
    
    public void delete(int id) throws SQLException {
        historyList.removeIf(history -> history.getId() == id);
        HistoryRepository.delete(id);
    }
    
    public void insert(History history) throws SQLException {
        add(history);
        HistoryRepository.insert(history);
    }

    @Override
    public Iterator iterator() {
        return historyList.iterator();
    }
}
