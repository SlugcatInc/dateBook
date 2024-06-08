import java.util.List;

public class RecordPresenterImpl implements RecordPresenter {
    private RecordModel model;
    private RecordView view;

    public RecordPresenterImpl(RecordModel model, RecordView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addRecord(String date, String time, String description) {
        model.addRecord(date, time, description);
    }

    @Override
    public void showRecords() {
        List<Record> records = model.getRecords();
        view.showRecords(records);
    }

    @Override
    public void searchRecordsByDate(String date) {
        List<Record> records = model.searchRecordsByDate(date);
        view.showSearchResult(records);
    }

    @Override
    public void searchRecordsByWeek(String week) {
        List<Record> records = model.searchRecordsByWeek(week);
        view.showSearchResult(records);
    }

    @Override
    public void sortRecords() {
        model.sortRecords();
        view.showRecords(model.getRecords());
    }

    @Override
    public void saveRecordsToFile(String filename) {
        model.saveRecordsToFile(filename);
        view.showError("Даты были сохранены: " + filename);

    }

    @Override
    public void loadRecordsFromFile(String filename) {
        model.loadRecordsFromFile(filename);
        view.showRecords(model.getRecords());

    }
}