import java.util.List;

public interface RecordView {
    void showRecords(List<Record> records);
    void showSearchResult(List<Record> records);
    void showError(String message);
}