public interface RecordPresenter {
    void addRecord(String date, String time, String description);
    void showRecords();
    void searchRecordsByDate(String date);
    void searchRecordsByWeek(String week);
    void sortRecords();
    void saveRecordsToFile(String filename);
    void loadRecordsFromFile(String filename);
}
