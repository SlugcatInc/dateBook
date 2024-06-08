import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordModelImpl implements RecordModel {
    private List<Record> records;

    public RecordModelImpl() {
        records = new ArrayList<>();
    }

    @Override
    public void addRecord(String date, String time, String description) {
        Record record = new Record(date, time, description);
        records.add(record);
    }

    @Override
    public List<Record> getRecords() {
        return records;
    }

    @Override
    public void saveRecordsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Record record : records) {
                writer.println(record.getDate() + "," + record.getTime() + "," + record.getDescription());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении записей в файл: " + e.getMessage());
        }
    }

    @Override
    public void loadRecordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] parts = line.split(",");
                Record record = new Record(parts[0], parts[1], parts[2]);
                records.add(record);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке записей из файла: " + e.getMessage());
        }
    }

    @Override
    public List<Record> searchRecordsByDate(String date) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            if (record.getDate().equals(date)) {
                result.add(record);
            }
        }
        return result;
    }

    @Override
    public List<Record> searchRecordsByWeek(String week) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            if (record.getDate().startsWith(week)) {
                result.add(record);
            }
        }
        return result;
    }

    @Override
    public void sortRecords() {
        records.sort((r1, r2) -> r1.getDate().compareTo(r2.getDate()));
    }
}