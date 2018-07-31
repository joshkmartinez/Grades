import { get } from "https";
const SCHOOL_LINK = " "
const API_URL = "https://${SCHOOL_LINK}/ParentPortal/LoginParent.aspx"

// ${var} <- syntax

let GET_DISTRICTS_LINK  = "https://ping.aeries.com/api/v1/schoolsearch/ca/AeriesAppParent/"

parseSearchParam (searchParam) {
    return searchParam.replace(/ /g,"%20")
    //have to replace spaces with %20 for the link
};

export default {

    searchDistrict(searchParam) {
        searchParam = parseSearchParam(searchParam)
        return get(`${GET_DISTRICTS_LINK}${searchParam}`)
        .then(response => response.json())
        .then(result => ({
        //list all the districts with an index number, tap on one, get the link
        //listings: result.data.listings,
        //total_listings: result.meta.total_listings,
      }));

    },

    login() {
        //send username and password to athuenticate
        //maybe send to server also
    }

};