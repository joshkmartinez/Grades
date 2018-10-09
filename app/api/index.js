import _ from 'lodash'
import schools from './schools'

export const getSchools = (limit = 21, query = '') => {
  return new Promise((resolve, reject) => {
    if (query.length === 0) {
      resolve(_.take(schools, limit))
    } else {
      const formattedQuery = query.toLowerCase()
      const results = _.filter(schools, user => {
        return contains(user, formattedQuery)
      })
      resolve(_.take(results, limit))
    }
  })
}

export default getSchools
