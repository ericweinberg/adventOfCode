package com.muddworks.adventOfCode.day4;

public class Day4Result {
    private String key;
    private Long number;
    private String md5Hash;

    public Day4Result(String key, Long number, String md5Hash) {
        this.key = key;
        this.number = number;
        this.md5Hash = md5Hash;
    }

    public String getKey() {
        return key;
    }

    public Long getNumber() {
        return number;
    }

    public String getMd5Hash() {
        return md5Hash;
    }

    @Override
    public String toString() {
        return "Day4Result{" +
                "key='" + key + '\'' +
                ", number=" + number +
                ", md5Hash='" + md5Hash + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day4Result that = (Day4Result) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return !(md5Hash != null ? !md5Hash.equals(that.md5Hash) : that.md5Hash != null);

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (md5Hash != null ? md5Hash.hashCode() : 0);
        return result;
    }
}
