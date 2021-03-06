package app.jweb.page.api;


import app.jweb.page.api.page.CreatePageRequest;
import app.jweb.page.api.page.DeletePageRequest;
import app.jweb.page.api.page.PageQuery;
import app.jweb.page.api.page.PageResponse;
import app.jweb.page.api.page.UpdatePageRequest;
import app.jweb.util.collection.QueryResponse;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Optional;

/**
 * @author chi
 */
@Path("/api/page/")
public interface PageWebService {
    @Path("/{id}")
    @GET
    PageResponse get(@PathParam("id") String id);


    @Path("/path/{path}")
    @GET
    Optional<PageResponse> findByPath(@PathParam("path") String path);

    @Path("/find")
    @PUT
    QueryResponse<PageResponse> find(PageQuery query);

    @POST
    PageResponse create(CreatePageRequest request);

    @Path("/{id}")
    @PUT
    PageResponse update(@PathParam("id") String id, UpdatePageRequest request);

    @Path("/delete")
    @POST
    void delete(DeletePageRequest request);
}
