package com.example.todolist;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class DataObject_Impl implements DataObject {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLIst;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfLIst;

  public DataObject_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLIst = new EntityInsertionAdapter<LIst>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tasks`(`id`,`task`,`description`,`category`,`duration`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LIst value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCategory());
        }
        stmt.bindLong(5, value.getDuration());
      }
    };
    this.__deletionAdapterOfLIst = new EntityDeletionOrUpdateAdapter<LIst>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tasks` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LIst value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void addTask(LIst task) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfLIst.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(LIst tasks) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfLIst.handle(tasks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<LIst> getTasks() {
    final String _sql = "select * from tasks";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("task");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfDuration = _cursor.getColumnIndexOrThrow("duration");
      final List<LIst> _result = new ArrayList<LIst>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LIst _item;
        _item = new LIst();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        _item.setCategory(_tmpCategory);
        final int _tmpDuration;
        _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
        _item.setDuration(_tmpDuration);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
