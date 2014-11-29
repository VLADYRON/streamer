package hu.tilos.radio.backend.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import hu.radio.tilos.model.Comment;
import hu.radio.tilos.model.Role;
import hu.radio.tilos.model.type.CommentStatus;
import hu.radio.tilos.model.type.CommentType;
import hu.tilos.radio.backend.Security;
import hu.tilos.radio.backend.Session;
import hu.tilos.radio.backend.converters.TagUtil;
import hu.tilos.radio.backend.data.input.CommentToSave;
import hu.tilos.radio.backend.data.response.CreateResponse;
import hu.tilos.radio.backend.data.types.CommentData;
import hu.tilos.radio.backend.episode.EpisodeUtil;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.*;

@Path("/api/v1/comment")
public class CommentController {

    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

    @Inject
    DozerBeanMapper modelMapper;

    @Inject
    EpisodeUtil episodeUtil;

    @Inject
    Session session;

    @Inject
    TagUtil tagUtil;

    @Inject
    DB db;

    @GET
    @Path("/{type}/{identifier}")
    @Security(role = Role.GUEST)
    @Produces("application/json")
    public List<CommentData> list(@PathParam("type") CommentType type, @PathParam("identifier") int id) {
        BasicDBObject query = new BasicDBObject();
        query.put("type", type.ordinal());
        query.put("identifier", id);
        query.put("status", CommentStatus.ACCEPTED);
        //FIXME status or current author
        DBCursor comments = db.getCollection("comment").find(query);

//        Map<Integer, CommentData> commentsById = new HashMap<>();
//
//        for (DBObject comment : comments) {
//            commentsById.put(comment.getId(), modelMapper.map(comment, CommentData.class));
//        }
//        for (Comment comment : comments) {
//            if (comment.getParent() != null) {
//                commentsById.get(comment.getParent().getId()).getChildren().add(commentsById.get(comment.getId()));
//            }
//        }

        List<CommentData> topLevelComments = new ArrayList();

//        for (Comment comment : comments) {
//            if (comment.getParent() == null) {
//                topLevelComments.add(commentsById.get(comment.getId()));
//            }
//        }

        return topLevelComments;
    }

    @GET
    @Path("/")
    @Security(role = Role.GUEST)
    @Produces("application/json")
    public List<CommentData> listAll(@QueryParam("status") String status) {
//        Query selectComments;
//        if (status == null) {
//            selectComments = entityManager.createQuery("SELECT c FROM Comment c ORDER BY c.created desc");
//        } else {
//            selectComments = entityManager.createQuery("SELECT c FROM Comment c WHERE c.status = :status ORDER BY c.created desc").setParameter("status", CommentStatus.valueOf(status));
//        }
//
//        List<Comment> comments = selectComments.getResultList();

        List<CommentData> commentDtos = new ArrayList();
//        for (Comment comment : comments) {
//            commentDtos.add(modelMapper.map(comment, CommentData.class));
//        }

        return commentDtos;
    }

    /**
     * @exclude
     */
    @POST
    @Path("/approve/{id}")
    @Security(role = Role.ADMIN)
    @Produces("application/json")
    @Transactional
    public CommentData approve(@PathParam("id") int id) {
//        Comment comment = entityManager.find(Comment.class, id);
//        comment.setStatus(CommentStatus.ACCEPTED);
//        entityManager.persist(comment);
//        return modelMapper.map(comment, CommentData.class);
        return null;
    }

    /**
     * @exclude
     */
    @DELETE
    @Path("/approve/{id}")
    @Security(role = Role.ADMIN)
    @Produces("application/json")
    @Transactional
    public void delete(@PathParam("id") int id) {
//        Comment comment = entityManager.find(Comment.class, id);
//
//        entityManager.remove(comment);

    }


    /**
     * @exclude
     */
    @Produces("application/json")
    @Security(role = Role.USER)
    @Path("/{type}/{identifier}")
    @POST
    @Transactional
    public CreateResponse create(@PathParam("type") CommentType type, @PathParam("identifier") int id, CommentToSave data) {
//        Comment comment = new Comment();
//        comment.setMoment(data.getMoment());
//        comment.setComment(data.getComment());
//        comment.setAuthor(session.getCurrentUser());
//        comment.setType(type);
//        comment.setIdentifier(id);
//        comment.setCreated(new Date());
//        if (data.getParentId() > 0) {
//            comment.setParent(entityManager.find(Comment.class, data.getParentId()));
//        }
//
//        entityManager.persist(comment);
//        entityManager.flush();
//        return new CreateResponse(comment.getId());
        return null;
    }


}