/* global myDetailsSbReactAppUrlRoot */
/* global myDetailsSbJwtToken */

import {CasFetch} from '../casFetch/CasFetch.js';

export const get_details = () => {
  let jwtToken = myDetailsSbJwtToken == null ? '' : myDetailsSbJwtToken;
  if (jwtToken == '') {
    let casFetch = new CasFetch(
        myDetailsSbReactAppUrlRoot + '/my-details-sb/casified/v1/details',
        {
          method: 'GET',
          credentials: 'include',
          headers: {
            Accept: '*' // <---- this header needs work. when just application/json, Java CAS client can't find saved URL
          }
        }
    );
    return casFetch.fetchJson();
  } else {
    let casFetch = new CasFetch(
        myDetailsSbReactAppUrlRoot + '/my-details-sb/casified/v1/details',
        {
          credentials: 'include',
          method: 'GET',
          headers: {
            Accept: 'application/json',
            Authorization: 'Bearer ' + myDetailsSbJwtToken
          }
        }
    );
    return casFetch.fetchJson();
  }
}

export const update_pref_name = async (inputPrefName) => {
  let jwtToken = myDetailsSbJwtToken == null ? '' : myDetailsSbJwtToken;
  if (jwtToken == '') {
    let casFetch = new CasFetch(
        myDetailsSbReactAppUrlRoot + '/my-details-sb/v1/preferred-name/' + inputPrefName,
        {
          method: 'POST',
          credentials: 'include',
          body: inputPrefName,
          headers: {
            Accept: '*' // <---- this header needs work. when just application/json, Java CAS client can't find saved URL
          }
        }
    );
    return casFetch.fetchJson();
  } else {
    let casFetch = new CasFetch(
        myDetailsSbReactAppUrlRoot + '/my-details-sb/v1/preferred-name/' + inputPrefName,
        {
          method: 'POST',
          credentials: 'include',
          body: inputPrefName,
          headers: {
            Authorization: 'Bearer ' + myDetailsSbJwtToken
          }
        }
    );
    return casFetch.fetchJson();
  }
}
