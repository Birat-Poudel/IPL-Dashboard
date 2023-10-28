import "./TeamTile.scss"
import { Link } from "react-router-dom"
import PropTypes from "prop-types"

const TeamTile = ({ teamName }) => {

    const imageUrl = `/assets/${teamName}.png`

    return (
        <div className="TeamTile">
            <div>
                <img className="team-tile-image" src={imageUrl} alt="IPL team" />
            </div>
            <h2 className="team-tile-name">
                <Link to={`/teams/${teamName}`}>
                    {teamName}
                </Link>
            </h2>
        </div>
    )
}

TeamTile.propTypes = {
    teamName: PropTypes.string.isRequired
};

export default TeamTile