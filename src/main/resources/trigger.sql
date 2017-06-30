--STORIES
--readcount
--chaptercount
--commentcount
--likecount
--ratedByCount


CREATE OR REPLACE TRIGGER READCOUNT_UPDATE
AFTER INSERT
ON READING
FOR EACH ROW
BEGIN

  UPDATE STORY
  SET READCOUNT = READCOUNT+1
  WHERE STORYID = :NEW.READSTORY ;

END ;
/

CREATE OR REPLACE TRIGGER CHAPTERCOUNT_UPDATE
AFTER INSERT
ON CHAPTER
FOR EACH ROW
BEGIN
  IF :NEW.ISPUBLISHED = 1 THEN
    UPDATE STORY
    SET STORY.CHAPTERCOUNT = STORY.CHAPTERCOUNT+1
    WHERE STORYID = :NEW.BELONGSTO ;
  END IF;
END ;
/

CREATE OR REPLACE TRIGGER COMMENTCOUNT_UPDATE
AFTER INSERT
  ON STORYCOMMENTS
FOR EACH ROW
  BEGIN

    UPDATE STORY
    SET STORY.COMMENTCOUNT = STORY.COMMENTCOUNT+1
    WHERE STORYID = :NEW.SCOMMENTEDON ;

  END ;
/

CREATE OR REPLACE TRIGGER LIKECOUNT_UPDATE
AFTER INSERT
  ON LIKES
FOR EACH ROW
  BEGIN

    UPDATE STORY
    SET STORY.LIKECOUNT = STORY.LIKECOUNT+1
    WHERE STORYID = :NEW.LIKEDSTORY ;

  END ;
/

CREATE OR REPLACE TRIGGER RATEDBYCOUNT_UPDATE
AFTER INSERT
  ON RATES
FOR EACH ROW
  BEGIN

    UPDATE STORY
    SET STORY.RATEDBYCOUNT = STORY.RATEDBYCOUNT+1
    WHERE STORYID = :NEW.RATEDSTORY ;

  END ;
/

--USERPROFILE
--followercount
--popularity

CREATE OR REPLACE TRIGGER FOLLOWERCOUNT_UPDATE
AFTER INSERT
  ON FOLLOWTABLE
FOR EACH ROW
  BEGIN

    UPDATE USERPROFILE
    SET USERPROFILE.FOLLOWERCOUNT = USERPROFILE.FOLLOWERCOUNT+1
    WHERE USERPROFILE.WRITER= :NEW.FOLLOWED ;

  END ;
/


CREATE OR REPLACE TRIGGER USERPROFILE_UPDATE
AFTER INSERT
  ON ACCOUNTUSER
FOR EACH ROW
  BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.USERNAME) ;
    IF :NEW.USERTYPE = 'user' THEN
    INSERT INTO USERPROFILE(WRITER, ABOUTWRITER, FOLLOWCOUNT, CURRENTMONTHFOLLOWER)
      VALUES (:NEW.USERNAME,NULL ,0,0);
    END IF ;

  END ;
/

