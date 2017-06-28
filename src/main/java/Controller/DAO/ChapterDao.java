package Controller.DAO;

import Model.ChapterEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by MiNNiE on 29-Apr-17.
 */
public interface ChapterDao {
   ChapterEntity getChapterByFilter(Map<String, List<String>> filterParams) throws SQLException;
   ChapterEntity getNewChapterByFilter(Map<String, List<String>> filterParams) throws SQLException;
   long insertChapter(ChapterEntity chapter) throws SQLException;
   boolean insertIntoPublishedList(ChapterEntity chapter);
   long getNextChapter(long chapterId, long storyid);
   boolean doExist(long chapterId, long storyid);
   boolean updateChapter(ChapterEntity chapter);
   boolean updatePreviousChapter(ChapterEntity chapter);
   boolean updateNextOfPrevChapter(ChapterEntity chapter);
   boolean deleteChapter(ChapterEntity chapter);
}
