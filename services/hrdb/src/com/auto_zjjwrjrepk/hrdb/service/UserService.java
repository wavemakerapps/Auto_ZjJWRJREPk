/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_zjjwrjrepk.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.auto_zjjwrjrepk.hrdb.User;

/**
 * Service object for domain model class {@link User}.
 */
public interface UserService {

    /**
     * Creates a new User. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on User if any.
     *
     * @param user Details of the User to be created; value cannot be null.
     * @return The newly created User.
     */
	User create(@Valid User user);


	/**
	 * Returns User by given id if exists.
	 *
	 * @param userIdInstance The id of the User to get; value cannot be null.
	 * @return User associated with the given userIdInstance.
     * @throws EntityNotFoundException If no User is found.
	 */
	User getById(Integer userIdInstance) throws EntityNotFoundException;

    /**
	 * Find and return the User by given id if exists, returns null otherwise.
	 *
	 * @param userIdInstance The id of the User to get; value cannot be null.
	 * @return User associated with the given userIdInstance.
	 */
	User findById(Integer userIdInstance);


	/**
	 * Updates the details of an existing User. It replaces all fields of the existing User with the given user.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on User if any.
     *
	 * @param user The details of the User to be updated; value cannot be null.
	 * @return The updated User.
	 * @throws EntityNotFoundException if no User is found with given input.
	 */
	User update(@Valid User user) throws EntityNotFoundException;

    /**
	 * Deletes an existing User with the given id.
	 *
	 * @param userIdInstance The id of the User to be deleted; value cannot be null.
	 * @return The deleted User.
	 * @throws EntityNotFoundException if no User found with the given id.
	 */
	User delete(Integer userIdInstance) throws EntityNotFoundException;

	/**
	 * Find all Users matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Users.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Users matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Users.
     *
     * @see Pageable
     * @see Page
	 */
    Page<User> findAll(String query, Pageable pageable);

    /**
	 * Exports all Users matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Users in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the User.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

