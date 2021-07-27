const express = require('express');
const router = express.Router();
const { getAll } = require('../mysql');
const { getOne } = require('../mysql');
const { insert } = require('../mysql');
const { borrarUno } = require('../mysql');
const { update } = require('../mysql');

router.get('/all', async (req, res)=>
{
    try
    {
        const data = await getAll();

        res.json({data});
    }
    catch(error)
    {
        res.json({érror});
    }
});

router.get('/one', async (req, res)=>
{
    try
    {
        const data = await getOne(1);

        res.json({data});
    }
    catch(error)
    {
        res.json({érror});
    }
});

router.get('/insert', async (req, res)=>
{
    try
    {
        const data = await insert();

        res.json({data});
    }
    catch(error)
    {
        res.json({érror});
    }
});

router.get('/borrar', async (req, res)=>
{
    try
    {
        const data = await borrarUno(3);

        res.json({data});
    }
    catch(error)
    {
        res.json({érror});
    }
});

router.get('/update', async (req, res)=>
{
    try
    {
        const data = await update(3);

        res.json({data});
    }
    catch(error)
    {
        res.json({érror});
    }
});








module.exports = router;