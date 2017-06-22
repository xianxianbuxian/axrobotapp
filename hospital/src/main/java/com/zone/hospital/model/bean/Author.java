package com.zone.hospital.model.bean;//package com.zone.hospital.model.bean;
//
//
//
//import java.util.List;
//
//
///**
// * Created by zone on 2017/4/4.
// */
//@Entity
//public class Author {
//    @Id
//    private Long id;
//    private String name;
//    private String sex;
//    private String alias;
//    @ToMany(referencedJoinProperty = "authorId")
//    private List<Post> posts;
//    /** Used to resolve relations */
//    @Generated(hash = 2040040024)
//    private transient DaoSession daoSession;
//    /** Used for active entity operations. */
//    @Generated(hash = 1264723625)
//    private transient AuthorDao myDao;
//    @Generated(hash = 2099528572)
//    public Author(Long id, String name, String sex, String alias) {
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//        this.alias = alias;
//    }
//    @Generated(hash = 64241762)
//    public Author() {
//    }
//    public Long getId() {
//        return this.id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getSex() {
//        return this.sex;
//    }
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//    /**
//     * To-many relationship, resolved on first access (and after reset).
//     * Changes to to-many relations are not persisted, make changes to the target entity.
//     */
//    @Generated(hash = 526478862)
//    public List<Post> getPosts() {
//        if (posts == null) {
//            final DaoSession daoSession = this.daoSession;
//            if (daoSession == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            PostDao targetDao = daoSession.getPostDao();
//            List<Post> postsNew = targetDao._queryAuthor_Posts(id);
//            synchronized (this) {
//                if (posts == null) {
//                    posts = postsNew;
//                }
//            }
//        }
//        return posts;
//    }
//    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
//    @Generated(hash = 802173039)
//    public synchronized void resetPosts() {
//        posts = null;
//    }
//    /**
//     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
//     * Entity must attached to an entity context.
//     */
//    @Generated(hash = 128553479)
//    public void delete() {
//        if (myDao == null) {
//            throw new DaoException("Entity is detached from DAO context");
//        }
//        myDao.delete(this);
//    }
//    /**
//     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
//     * Entity must attached to an entity context.
//     */
//    @Generated(hash = 1942392019)
//    public void refresh() {
//        if (myDao == null) {
//            throw new DaoException("Entity is detached from DAO context");
//        }
//        myDao.refresh(this);
//    }
//    /**
//     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
//     * Entity must attached to an entity context.
//     */
//    @Generated(hash = 713229351)
//    public void update() {
//        if (myDao == null) {
//            throw new DaoException("Entity is detached from DAO context");
//        }
//        myDao.update(this);
//    }
//    public String getAlias() {
//        return this.alias;
//    }
//    public void setAlias(String alias) {
//        this.alias = alias;
//    }
//    /** called by internal mechanisms, do not call yourself. */
//    @Generated(hash = 22439443)
//    public void __setDaoSession(DaoSession daoSession) {
//        this.daoSession = daoSession;
//        myDao = daoSession != null ? daoSession.getAuthorDao() : null;
//    }
//}
