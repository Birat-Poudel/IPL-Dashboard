import { Link } from "react-router-dom"
import './YearSelector.scss'
import PropTypes from 'prop-types'

const YearSelector = ({ teamName }) => {

    let years = []
    const startYear = 2008
    const endYear = 2020

    for (let i = startYear; i <= endYear; i++) {
        years.push(i)
    }

    return (
        <ol className="YearSelector">
            {years.map(year =>

                <li key={year}>
                    <Link to={`/teams/${teamName}/matches/${year}`}>{year}</Link>
                </li>
            )}
        </ol>
    )
}

YearSelector.propTypes = {
    teamName: PropTypes.string.isRequired
};

export default YearSelector