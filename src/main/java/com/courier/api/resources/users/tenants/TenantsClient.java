/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.users.tenants;

import com.courier.api.core.ApiError;
import com.courier.api.core.ClientOptions;
import com.courier.api.core.MediaTypes;
import com.courier.api.core.ObjectMappers;
import com.courier.api.core.RequestOptions;
import com.courier.api.resources.users.tenants.requests.AddUserToMultipleTenantsParams;
import com.courier.api.resources.users.tenants.requests.AddUserToSingleTenantsParams;
import com.courier.api.resources.users.tenants.requests.ListTenantsForUserParams;
import com.courier.api.resources.users.tenants.types.ListTenantsForUserResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TenantsClient {
    protected final ClientOptions clientOptions;

    public TenantsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * This endpoint is used to add a user to
     * multiple tenants in one call.
     * A custom profile can also be supplied for each tenant.
     * This profile will be merged with the user's main
     * profile when sending to the user with that tenant.
     */
    public void addMultple(String userId, AddUserToMultipleTenantsParams request) {
        addMultple(userId, request, null);
    }

    /**
     * This endpoint is used to add a user to
     * multiple tenants in one call.
     * A custom profile can also be supplied for each tenant.
     * This profile will be merged with the user's main
     * profile when sending to the user with that tenant.
     */
    public void addMultple(String userId, AddUserToMultipleTenantsParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("tenants")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint is used to add a single tenant.
     * <p>A custom profile can also be supplied with the tenant.
     * This profile will be merged with the user's main profile
     * when sending to the user with that tenant.</p>
     */
    public void add(String userId, String tenantId, AddUserToSingleTenantsParams request) {
        add(userId, tenantId, request, null);
    }

    /**
     * This endpoint is used to add a single tenant.
     * <p>A custom profile can also be supplied with the tenant.
     * This profile will be merged with the user's main profile
     * when sending to the user with that tenant.</p>
     */
    public void add(
            String userId, String tenantId, AddUserToSingleTenantsParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("tenants")
                .addPathSegment(tenantId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes a user from any tenants they may have been associated with.
     */
    public void removeAll(String userId) {
        removeAll(userId, null);
    }

    /**
     * Removes a user from any tenants they may have been associated with.
     */
    public void removeAll(String userId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("tenants")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes a user from the supplied tenant.
     */
    public void remove(String userId, String tenantId) {
        remove(userId, tenantId, null);
    }

    /**
     * Removes a user from the supplied tenant.
     */
    public void remove(String userId, String tenantId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("tenants")
                .addPathSegment(tenantId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a paginated list of user tenant associations.
     */
    public ListTenantsForUserResponse list(String userId) {
        return list(userId, ListTenantsForUserParams.builder().build());
    }

    /**
     * Returns a paginated list of user tenant associations.
     */
    public ListTenantsForUserResponse list(String userId, ListTenantsForUserParams request) {
        return list(userId, request, null);
    }

    /**
     * Returns a paginated list of user tenant associations.
     */
    public ListTenantsForUserResponse list(
            String userId, ListTenantsForUserParams request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("tenants");
        if (request.getLimit().isPresent()) {
            httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ListTenantsForUserResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
