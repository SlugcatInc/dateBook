import java.util.List;

public class RecordViewImpl implements RecordView {
    @Override
    public void showRecords(List<Record> records) {
        for (Record record : records) {
            System.out.println(record.getDate() + " " + record.getTime() + " - " + record.getDescription());
        }
    }

    @Override
    public void showSearchResult(List<Record> records) {
        System.out.println("Результат поиска:");
        showRecords(records);
    }

    @Override
    public void showError(String message) {
        System.err.println("Ошибка: " + message);
    }
}