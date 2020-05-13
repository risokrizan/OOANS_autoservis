package ooans.OOANS_autoservis.domain;

import java.util.List;

public class ServiceHistory {
    List<String> history;

    @Override
    public String toString() {
        return "ServiceHistory{" +
                "history=" + history +
                '}';
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }
}
