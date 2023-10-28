import { useEffect, useState } from 'react'
import MatchDetailCard from '../components/MatchDetailCard'
import { useParams } from 'react-router-dom'
import './MatchPage.scss'
import YearSelector from '../components/YearSelector'
import { Link } from 'react-router-dom'

export const MatchPage = () => {

    const [matches, setMatches] = useState([])
    const { teamName, year } = useParams()

    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch(`http://localhost:8080/api/v1/teams/${teamName}/matches?year=${year}`)
                const data = await response.json()
                setMatches(data)
            }
            fetchMatches()
        }, [teamName, year]
    )

    return (
        <>
            <div className="MatchPage">
                <div className="more-link2">
                    <Link to={`/teams/${teamName}`}>&#8592;</Link>
                </div>
                <div className='year-selector'>
                    <h3>Select Year</h3>
                    <YearSelector teamName={teamName} />
                </div>
                <div>
                    <h1 className='page-heading'>{teamName} matches in {year}</h1>
                    {matches.map(match => <MatchDetailCard key={match.id} teamName={teamName} match={match} />)}
                </div>
            </div>
        </>
    )
}