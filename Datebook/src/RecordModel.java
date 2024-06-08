import java.util.List;

public interface RecordModel {
    void addRecord(String date, String time, String description);
    List<Record> getRecords();
    void saveRecordsToFile(String filename);
    void loadRecordsFromFile(String filename);
    List<Record> searchRecordsByDate(String date);
    List<Record> searchRecordsByWeek(String week);
    void sortRecords();
}